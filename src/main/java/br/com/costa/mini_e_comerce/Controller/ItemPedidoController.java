package br.com.costa.mini_e_comerce.Controller;


import br.com.costa.mini_e_comerce.DataBase.ModelDto.ItemPedidoModelDto;
import br.com.costa.mini_e_comerce.Services.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/itempedido")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createItemPedido(@Valid @RequestBody ItemPedidoModelDto itemPedidoModelDto){
        itemPedidoService.crateItemPedido(itemPedidoModelDto);
    }
}
