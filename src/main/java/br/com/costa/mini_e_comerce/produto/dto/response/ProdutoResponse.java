package br.com.costa.mini_e_comerce.produto.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponse(
        UUID id,
        String nome,
        BigDecimal preco,
        Integer estoque
) {}