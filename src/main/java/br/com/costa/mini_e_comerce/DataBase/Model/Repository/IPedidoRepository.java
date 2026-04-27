package br.com.costa.mini_e_comerce.DataBase.Model.Repository;

import br.com.costa.mini_e_comerce.DataBase.Model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPedidoRepository extends JpaRepository<PedidoModel, Integer> {
}
