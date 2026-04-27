package br.com.costa.mini_e_comerce.DataBase.ModelDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModelDto {

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private Integer quantidadeEstoque;

}
