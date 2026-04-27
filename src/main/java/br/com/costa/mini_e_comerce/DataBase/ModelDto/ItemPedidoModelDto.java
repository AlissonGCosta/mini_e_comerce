package br.com.costa.mini_e_comerce.DataBase.ModelDto;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPedidoModelDto {

    @NotNull
    private Integer quantidade;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private BigDecimal subTotal;
}
