package br.com.costa.mini_e_comerce.pedidos.service;

import br.com.costa.mini_e_comerce.cliente.model.ClienteModel;
import br.com.costa.mini_e_comerce.cliente.repository.IClienteRepository;
import br.com.costa.mini_e_comerce.pedidos.dto.response.AlterarStatusPedidoDto;
import br.com.costa.mini_e_comerce.pedidos.repository.IPedidoRepository;
import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import br.com.costa.mini_e_comerce.pedidos.dto.request.PedidoModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class PedidosService {

    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;

    public void createPedido(PedidoModelDto pedidoModelDto) {
        ClienteModel cliente = clienteRepository.findById(pedidoModelDto.getClienteId())
                .orElseThrow(() -> new RuntimeException("cliente nao encontrado"));



        PedidoModel pedido = PedidoModel.builder()
                .cliente(cliente)
                .status(pedidoModelDto.getStatus())
                .dataCriacao(LocalDate.now())
                .build();

        cliente.adicionarPedido(pedido);

        clienteRepository.save(cliente);



    }

    public List<PedidoModel> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> listarpedidosPorId(UUID uuid) {
        return pedidoRepository.findById(uuid);
    }

    public PedidoModel alterarStatusPedidosPorId(UUID id, AlterarStatusPedidoDto alterarStatusPedidoDto) {

        PedidoModel pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("pedido nao encontrado"));

        pedido.setStatus(alterarStatusPedidoDto.getStatus());



        return pedidoRepository.save(pedido);




    }
}

