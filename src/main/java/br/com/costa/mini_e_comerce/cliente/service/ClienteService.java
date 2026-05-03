package br.com.costa.mini_e_comerce.cliente.service;


import br.com.costa.mini_e_comerce.cliente.model.ClienteModel;
import br.com.costa.mini_e_comerce.cliente.repository.IClienteRepository;
import br.com.costa.mini_e_comerce.cliente.dtos.request.ClienteModelDto;
import br.com.costa.mini_e_comerce.cliente.dtos.response.ListarClienteDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
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

    public List<ListarClienteDto> listarTodosClientes() {

       List <ClienteModel> cliente = clienteRepository.findAll();



       return cliente.stream()
               .map(c -> new ListarClienteDto(c.getId(), c.getNome(), c.getEmail(), c.getPedidos() ))
               .toList();



    }
}
