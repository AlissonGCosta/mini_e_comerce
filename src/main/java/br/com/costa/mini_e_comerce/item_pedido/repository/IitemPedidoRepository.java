package br.com.costa.mini_e_comerce.item_pedido.repository;

import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.UUID;

public interface IitemPedidoRepository extends JpaRepository<ItemPedidoModel, UUID> {
}
