package br.com.costa.mini_e_comerce.pedidos.dto.response;

import br.com.costa.mini_e_comerce.cliente.model.ClienteModel;
import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListarPedidoDto {

    private UUID id;
    private LocalDate dataPedido;
    private String status;
    private BigDecimal total;
    private List<ItemPedidoModel> itens;




}
