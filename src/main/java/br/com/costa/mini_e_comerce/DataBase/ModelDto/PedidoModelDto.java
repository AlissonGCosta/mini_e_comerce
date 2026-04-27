package br.com.costa.mini_e_comerce.DataBase.ModelDto;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModelDto {

    @NotBlank
    private String dataCriacao;

    @NotBlank
    private String status;

    @NotNull
    private Integer totalPedido;
}
