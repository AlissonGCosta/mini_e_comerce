package br.com.costa.mini_e_comerce.pedidos.controller;

import br.com.costa.mini_e_comerce.pedidos.dto.response.AlterarStatusPedidoDto;
import br.com.costa.mini_e_comerce.pedidos.dto.response.ListarPedidoDto;
import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import br.com.costa.mini_e_comerce.pedidos.dto.request.PedidoModelDto;
import br.com.costa.mini_e_comerce.pedidos.service.PedidosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pedidos")
public class PedidosController {

    private final PedidosService pedidosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarPedidos(@Valid @RequestBody PedidoModelDto pedidoModelDto) {
        pedidosService.createPedido(pedidoModelDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListarPedidoDto> listarPedidos() {
        return pedidosService.listarTodosPedidos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ListarPedidoDto> listarPedidoPorID(@PathVariable UUID id){
        return ResponseEntity.ok(pedidosService.listarpedidosPorId(id));
    }

    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.OK  )
    public void alterarStatus(@PathVariable UUID id, @Valid @RequestBody AlterarStatusPedidoDto alterarStatusPedidoDto) {
        pedidosService.alterarStatusPedidosPorId(id, alterarStatusPedidoDto);
    }
}
