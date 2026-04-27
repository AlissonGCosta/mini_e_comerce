package br.com.costa.mini_e_comerce.DataBase.Model.Repository;

import br.com.costa.mini_e_comerce.DataBase.Model.PedidoModel;
import br.com.costa.mini_e_comerce.DataBase.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepositroy extends JpaRepository<ProdutoModel, Integer> {
}
