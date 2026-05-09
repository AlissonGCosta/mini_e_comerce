package br.com.costa.mini_e_comerce.item_pedido.dtos.respone;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemDoPedidoResponse(
        UUID id,
        UUID produtoId,
        String produtoNome,
        Integer quantidade,
        BigDecimal preco,
        BigDecimal subTotal

) {
}
