package br.com.costa.mini_e_comerce.DataBase.Model.Repository;

import br.com.costa.mini_e_comerce.DataBase.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface IProdutoRepository extends JpaRepository<ProdutoModel, UUID> {

}
