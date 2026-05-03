package br.com.costa.mini_e_comerce.pedidos.repository;

import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface IPedidoRepository extends JpaRepository<PedidoModel, UUID> {


}
