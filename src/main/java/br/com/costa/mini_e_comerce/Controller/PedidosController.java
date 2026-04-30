package br.com.costa.mini_e_comerce.Controller;

import br.com.costa.mini_e_comerce.DataBase.Model.PedidoModel;
import br.com.costa.mini_e_comerce.DataBase.ModelDto.PedidoModelDto;
import br.com.costa.mini_e_comerce.Services.PedidosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public List<PedidoModel> listarPedidos() {
        return pedidosService.listarTodosPedidos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PedidoModel> listarPedidoPorID(@PathVariable UUID id){
        return pedidosService.listarpedidosPorId(id);
    }
}
