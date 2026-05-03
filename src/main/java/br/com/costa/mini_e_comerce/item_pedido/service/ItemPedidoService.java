package br.com.costa.mini_e_comerce.item_pedido.service;

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
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class ItemPedidoService {

    private final IitemPedidoRepository itemPedidoRepository;
    private final IProdutoRepository produtoRepository;
    private final IPedidoRepository pedidoRepository;

    public void crateItemPedido(@Valid ItemPedidoModelDto itemPedidoModelDto) {
        ProdutoModel produto = produtoRepository.findByNome(itemPedidoModelDto.getNomeProduto())
                .orElseThrow(() -> new RuntimeException("produto nao encontrado"));

        PedidoModel pedido = pedidoRepository.findById(itemPedidoModelDto.getPedidoId())
                .orElseThrow(() -> new RuntimeException("pedido nao encontrado"));

        ItemPedidoModel ItemPedido = ItemPedidoModel.builder()
                .produto(produto)
                .pedido(pedido)
                .quantidade(itemPedidoModelDto.getQuantidade())
                .subTotal(produto.getPreco())
                .preco(produto.getPreco())
                .build();

        pedido.adcionarItem(ItemPedido);
        produto.adcionarItemProduto(ItemPedido);


        itemPedidoRepository.save(ItemPedido);

    }

    public List<ItemPedidoModel> listarTodosPedidos(){
        return itemPedidoRepository.findAll();
    }
}
