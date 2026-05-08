package br.com.costa.mini_e_comerce.cliente.service;


import br.com.costa.mini_e_comerce.cliente.model.ClienteModel;
import br.com.costa.mini_e_comerce.cliente.repository.IClienteRepository;
import br.com.costa.mini_e_comerce.cliente.dtos.request.ClienteModelDto;
import br.com.costa.mini_e_comerce.cliente.dtos.response.ListarClienteDto;
import br.com.costa.mini_e_comerce.global.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            throw new ResourceNotFoundException("Cliente já cadastrado com esse email");
        }

        ClienteModel novoCliente = ClienteModel.builder()
                .nome(clienteModelDto.getNome())
                .email(clienteModelDto.getEmail())
                .build();



        clienteRepository.save(novoCliente);


    }

    public List<ListarClienteDto> listarTodosClientes() {

       List <ClienteModel> cliente = clienteRepository.findAll();



       return cliente.stream()
               .map(c -> new ListarClienteDto(c.getId(), c.getNome(), c.getEmail(), c.getPedidos() ))
               .toList();



    }

    public Page<ListarClienteDto> listarTodosClientesPaginado(int page, int linesPerPage) {
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.by(Sort.Direction.DESC, "id"));

        return clienteRepository.findAll(pageable)
                .map(c -> new ListarClienteDto(c.getId(), c.getNome(), c.getEmail(), c.getPedidos() ));
    }
}
