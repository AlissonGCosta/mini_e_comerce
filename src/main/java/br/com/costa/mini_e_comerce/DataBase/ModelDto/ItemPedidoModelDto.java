package br.com.costa.mini_e_comerce.DataBase.ModelDto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPedidoModelDto {

    @NotBlank
    private String nomeProduto;

    @NotNull
    private UUID pedidoId;

    @NotNull
    private Integer quantidade;




}
