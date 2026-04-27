package br.com.costa.mini_e_comerce.DataBase.Model.Repository;

import br.com.costa.mini_e_comerce.DataBase.Model.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface IitemPedidoRepository extends JpaRepository<ItemPedidoModel, BigDecimal> {
}
