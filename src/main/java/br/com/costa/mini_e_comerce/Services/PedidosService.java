package br.com.costa.mini_e_comerce.Services;

import br.com.costa.mini_e_comerce.DataBase.Model.ClienteModel;
import br.com.costa.mini_e_comerce.DataBase.Model.PedidoModel;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IClienteRepository;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IPedidoRepository;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IProdutoRepository;
import br.com.costa.mini_e_comerce.DataBase.ModelDto.PedidoModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class PedidosService {

    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;

    public void createPedido(PedidoModelDto pedidoModelDto) {
        ClienteModel pedidoClienteId = clienteRepository.findById(pedidoModelDto.getClienteId())
                .orElseThrow(() -> new RuntimeException("cliente nao encontrado"));


        PedidoModel pedido = PedidoModel.builder()
                .cliente(pedidoClienteId)
                .status(pedidoModelDto.getStatus())
                .dataCriacao(LocalDate.now())
                .totalPedido(pedidoModelDto.getQuantidade())
                .build();

        pedidoRepository.save(pedido);

        pedido.setCliente(pedidoClienteId);


    }
}

