package br.com.costa.mini_e_comerce.item_pedido.dtos.respone;

import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import br.com.costa.mini_e_comerce.produto.model.ProdutoModel;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListarItemPedidoDto {

    private UUID id;
    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal subTotal;

    private UUID pedidoId;
    private UUID produtoId;
    private String produtoNome;



}
