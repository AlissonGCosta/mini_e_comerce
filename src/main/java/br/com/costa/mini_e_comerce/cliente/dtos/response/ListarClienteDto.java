package br.com.costa.mini_e_comerce.cliente.dtos.response;

import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ListarClienteDto {

    private UUID id;
    private String nome;
    private String email;
    private List<PedidoModel> pedidos;

    public ListarClienteDto(UUID id, String nome, String email, List<PedidoModel> pedidos){

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pedidos = pedidos;

    }
}

