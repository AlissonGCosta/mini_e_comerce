package br.com.costa.mini_e_comerce.DataBase.ModelDto;


import jakarta.persistence.Entity;
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

    @NotNull
    private UUID pedidoId;

    @NotBlank
    private String status;


}
