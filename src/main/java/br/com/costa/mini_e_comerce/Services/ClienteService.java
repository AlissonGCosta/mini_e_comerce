package br.com.costa.mini_e_comerce.Services;


import br.com.costa.mini_e_comerce.DataBase.Model.ClienteModel;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IClienteRepository;
import br.com.costa.mini_e_comerce.DataBase.ModelDto.ClienteModelDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final IClienteRepository clienteRepository;

    public void createCliente(@Valid ClienteModelDto clienteModelDto) {
        ClienteModel cliente = clienteRepository.findByEmail(clienteModelDto.getEmail())
                .orElse(null);

        if (cliente != null) {

        }

        clienteRepository.save(ClienteModel.builder()
                .nome(clienteModelDto.getNome())
                .email(clienteModelDto.getEmail())
                .build());
    }

    public List<ClienteModel> listarTodosClientes() {
      return   clienteRepository.findAll();
    }
}
