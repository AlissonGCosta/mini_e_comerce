package br.com.costa.mini_e_comerce.item_pedido.controller;


import br.com.costa.mini_e_comerce.item_pedido.dtos.respone.ListarItemPedidoDto;
import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import br.com.costa.mini_e_comerce.item_pedido.dtos.request.ItemPedidoModelDto;
import br.com.costa.mini_e_comerce.item_pedido.service.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public List<ListarItemPedidoDto> getItemPedidos(){
        return itemPedidoService.listarTodosPedidos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemPedido(@PathVariable UUID id){
        itemPedidoService.deletarItemPedido(id);
        return ResponseEntity.noContent().build();
    }
}
