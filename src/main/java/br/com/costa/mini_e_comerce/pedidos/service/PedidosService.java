package br.com.costa.mini_e_comerce.pedidos.service;

import br.com.costa.mini_e_comerce.cliente.model.ClienteModel;
import br.com.costa.mini_e_comerce.cliente.repository.IClienteRepository;
import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import br.com.costa.mini_e_comerce.pedidos.dto.response.AlterarStatusPedidoDto;
import br.com.costa.mini_e_comerce.pedidos.dto.response.ListarPedidoDto;
import br.com.costa.mini_e_comerce.pedidos.repository.IPedidoRepository;
import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import br.com.costa.mini_e_comerce.pedidos.dto.request.PedidoModelDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
                .total(BigDecimal.ZERO)
                .build();

        cliente.adicionarPedido(pedido);

        BigDecimal total = pedido.getItens().stream()
                        .map(ItemPedidoModel::getSubTotal)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        pedido.setTotal(total);

        clienteRepository.save(cliente);
        pedidoRepository.save(pedido);


    }

    public List<ListarPedidoDto> listarTodosPedidos() {

        return pedidoRepository.findAll()
                .stream()
                .map(pedido -> ListarPedidoDto.builder()
                        .id(pedido.getId())
                        .status(pedido.getStatus())
                        .dataPedido(pedido.getDataCriacao())
                        .itens(pedido.getItens())
                        .build())
                .toList();



    }

    public ListarPedidoDto listarpedidosPorId(UUID uuid) {

        PedidoModel pedido = pedidoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("pedido nao encontrado "+ uuid));

        return ListarPedidoDtoResponse(pedido);
    }

    private ListarPedidoDto ListarPedidoDtoResponse(PedidoModel pedidoModel) {
        return ListarPedidoDto.builder()
                .id(pedidoModel.getId())
                .status(pedidoModel.getStatus())
                .dataPedido(pedidoModel.getDataCriacao())
                .total(pedidoModel.getTotal())
                .itens(pedidoModel.getItens())
                .build();

    }

    public void alterarStatusPedidosPorId(UUID id, AlterarStatusPedidoDto alterarStatusPedidoDto) {

        PedidoModel pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("pedido nao encontrado"));

        pedido.setStatus(alterarStatusPedidoDto.getStatus());

        pedidoRepository.save(pedido);




    }
}

