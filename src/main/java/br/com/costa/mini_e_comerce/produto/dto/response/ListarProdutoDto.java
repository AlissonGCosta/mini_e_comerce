package br.com.costa.mini_e_comerce.produto.dto.response;

import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListarProdutoDto {

    private UUID id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private List<ItemPedidoModel> listaProdutosEmPedido;


}
