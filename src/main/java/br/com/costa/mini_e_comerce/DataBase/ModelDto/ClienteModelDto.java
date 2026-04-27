package br.com.costa.mini_e_comerce.DataBase.ModelDto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModelDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;
}
