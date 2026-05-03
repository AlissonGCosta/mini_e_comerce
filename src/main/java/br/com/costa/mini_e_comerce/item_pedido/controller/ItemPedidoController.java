package br.com.costa.mini_e_comerce.item_pedido.controller;


import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import br.com.costa.mini_e_comerce.item_pedido.dtos.request.ItemPedidoModelDto;
import br.com.costa.mini_e_comerce.item_pedido.service.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemPedidoModel> getItemPedidos(){
        return itemPedidoService.listarTodosPedidos();
    }
}
