package br.com.costa.mini_e_comerce.cliente.controller;

import br.com.costa.mini_e_comerce.cliente.dtos.request.ClienteModelDto;
import br.com.costa.mini_e_comerce.cliente.dtos.response.ListarClienteDto;
import br.com.costa.mini_e_comerce.cliente.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/clientes")
@Validated
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCliente(@Valid @RequestBody ClienteModelDto clienteModelDto)  {
        clienteService.createCliente(clienteModelDto);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListarClienteDto> listarClientes() {
       return clienteService.listarTodosClientes();
    }

    @GetMapping("/pg")
    @ResponseStatus(HttpStatus.OK)
    public Page<ListarClienteDto> listarClientes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return clienteService.listarTodosClientesPaginado(page, size);
    }

}
