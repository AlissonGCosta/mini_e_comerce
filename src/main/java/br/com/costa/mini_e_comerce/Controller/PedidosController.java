package br.com.costa.mini_e_comerce.Controller;

import br.com.costa.mini_e_comerce.DataBase.ModelDto.PedidoModelDto;
import br.com.costa.mini_e_comerce.Services.PedidosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
