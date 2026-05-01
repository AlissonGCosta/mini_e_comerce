package br.com.costa.mini_e_comerce.Services;

import br.com.costa.mini_e_comerce.DataBase.Model.ItemPedidoModel;
import br.com.costa.mini_e_comerce.DataBase.Model.PedidoModel;
import br.com.costa.mini_e_comerce.DataBase.Model.ProdutoModel;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IPedidoRepository;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IProdutoRepository;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IitemPedidoRepository;
import br.com.costa.mini_e_comerce.DataBase.ModelDto.ItemPedidoModelDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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


        itemPedidoRepository.save(ItemPedido);

    }
}
