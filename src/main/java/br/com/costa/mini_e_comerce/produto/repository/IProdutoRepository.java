package br.com.costa.mini_e_comerce.produto.repository;

import br.com.costa.mini_e_comerce.produto.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;

public interface IProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
 Optional<ProdutoModel> findByNome(String nome);
}
