package br.com.costa.mini_e_comerce.DataBase.Model.Repository;

import br.com.costa.mini_e_comerce.DataBase.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IClienteRepository extends JpaRepository<ClienteModel, UUID> {

    Optional<ClienteModel> findByEmail(String email);
}
