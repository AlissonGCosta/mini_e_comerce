package br.com.costa.mini_e_comerce.DataBase.Model.Repository;

import br.com.costa.mini_e_comerce.DataBase.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
}
