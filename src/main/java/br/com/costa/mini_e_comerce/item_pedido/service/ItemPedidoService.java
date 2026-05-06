package br.com.costa.mini_e_comerce.item_pedido.service;

import br.com.costa.mini_e_comerce.item_pedido.dtos.respone.ListarItemPedidoDto;
import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import br.com.costa.mini_e_comerce.produto.model.ProdutoModel;
import br.com.costa.mini_e_comerce.pedidos.repository.IPedidoRepository;
import br.com.costa.mini_e_comerce.produto.repository.IProdutoRepository;
import br.com.costa.mini_e_comerce.item_pedido.repository.IitemPedidoRepository;
import br.com.costa.mini_e_comerce.item_pedido.dtos.request.ItemPedidoModelDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class ItemPedidoService {

    private final IitemPedidoRepository itemPedidoRepository;
    private final IProdutoRepository produtoRepository;
    private final IPedidoRepository pedidoRepository;

    @Transactional
    public void crateItemPedido(@Valid ItemPedidoModelDto itemPedidoModelDto) {



        ProdutoModel produto = produtoRepository.findByNome(itemPedidoModelDto.getNomeProduto())
                .orElseThrow(() -> new RuntimeException("produto nao encontrado"));

        if(itemPedidoModelDto.getQuantidade() <= 0){
            throw new RuntimeException("Quantidade Deve ser maior que zero");
        }

        if(produto.getQuantidadeEstoque() < itemPedidoModelDto.getQuantidade()){
            throw new RuntimeException("Estoque insuficiente");
        }

        PedidoModel pedido = pedidoRepository.findById(itemPedidoModelDto.getPedidoId())
                .orElseThrow(() -> new RuntimeException("pedido nao encontrado"));

        ItemPedidoModel ItemPedido = ItemPedidoModel.builder()
                .produto(produto)
                .pedido(pedido)
                .quantidade(itemPedidoModelDto.getQuantidade())
                .subTotal(produto.getPreco().multiply(BigDecimal.valueOf(itemPedidoModelDto.getQuantidade())))
                .preco(produto.getPreco())
                .build();

        pedido.adcionarItem(ItemPedido);
        produto.adcionarItemProduto(ItemPedido);
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - ItemPedido.getQuantidade());
        pedido.setStatus("ABERTO");

        BigDecimal total = pedido.getItens().stream()
                .map(ItemPedidoModel::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        pedido.setTotal(total);

        itemPedidoRepository.save(ItemPedido);

    }

    public List<ListarItemPedidoDto> listarTodosPedidos(){

        return itemPedidoRepository.findAll()
                .stream()
                .map(item -> ListarItemPedidoDto.builder()
                        .id(item.getId())
                        .quantidade(item.getQuantidade())
                        .preco(item.getPreco())
                        .subTotal(item.getSubTotal())
                        .pedidoId(item.getPedido().getId())
                        .produtoId(item.getProduto().getId())
                        .produtoNome(item.getProduto().getNome())
                        .build())
                .toList();
    }

    public void deletarItemPedido(@Valid UUID itemPedidoId) {
        if(!itemPedidoRepository.existsById(itemPedidoId)) {
            throw new RuntimeException("item pedido nao encontrado");
        }
        itemPedidoRepository.deleteById(itemPedidoId);
    }

    public void deletarTudoItemPedido(){
        itemPedidoRepository.deleteAll();
    }
}
