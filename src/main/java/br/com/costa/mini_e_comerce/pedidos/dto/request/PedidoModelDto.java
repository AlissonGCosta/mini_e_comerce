package br.com.costa.mini_e_comerce.pedidos.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModelDto {

    @NotNull
    private UUID clienteId;

   @NotNull
   private Integer quantidade;


    @NotBlank
    private String status;


}
