package br.com.costa.mini_e_comerce.DataBase.ModelDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlterarStatusPedidoDto {


    @NotBlank
    private String status;
}
