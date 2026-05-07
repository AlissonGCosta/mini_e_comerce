package br.com.costa.mini_e_comerce.produto.dto.request;

import java.math.BigDecimal;

public record ProdutoUpdateRequest(
        String nome,
        BigDecimal preco,
        Integer quantidadeEstoque
) {
}
