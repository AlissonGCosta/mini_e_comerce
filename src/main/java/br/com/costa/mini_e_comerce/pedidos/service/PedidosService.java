package br.com.costa.mini_e_comerce.pedidos.service;

import br.com.costa.mini_e_comerce.cliente.model.ClienteModel;
import br.com.costa.mini_e_comerce.cliente.repository.IClienteRepository;
import br.com.costa.mini_e_comerce.global.exception.ResourceNotFoundException;
import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import br.com.costa.mini_e_comerce.pedidos.dto.response.AlterarStatusPedidoDto;
import br.com.costa.mini_e_comerce.pedidos.dto.response.ListarPedidoDto;
import br.com.costa.mini_e_comerce.pedidos.repository.IPedidoRepository;
import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import br.com.costa.mini_e_comerce.pedidos.dto.request.PedidoModelDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
                .orElseThrow(() -> new ResourceNotFoundException("cliente nao encontrado"));


        PedidoModel pedido = PedidoModel.builder()
                .cliente(cliente)
                .status("CRIADO")
                .total(BigDecimal.ZERO)
                .dataCriacao(LocalDate.now())

                .build();

        cliente.adicionarPedido(pedido);



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
                        .total(pedido.getTotal())
                        .itens(pedido.getItens())
                        .build())
                .toList();



    }

    public ListarPedidoDto listarpedidosPorId(UUID uuid) {

        PedidoModel pedido = pedidoRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("pedido nao encontrado "+ uuid));

        return ListarPedidoDtoResponse(pedido);
    }

    private ListarPedidoDto ListarPedidoDtoResponse(PedidoModel pedidoModel) {
        return ListarPedidoDto.builder()
                .id(pedidoModel.getId())
                .status(pedidoModel.getStatus())
                .total(pedidoModel.getTotal())
                .dataPedido(pedidoModel.getDataCriacao())
                .itens(pedidoModel.getItens())
                .build();

    }

    public void alterarStatusPedidosPorId(UUID id, AlterarStatusPedidoDto alterarStatusPedidoDto) {

        PedidoModel pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("pedido nao encontrado"));

        pedido.setStatus(alterarStatusPedidoDto.getStatus());

        pedidoRepository.save(pedido);




    }

    public Page<ListarPedidoDto> listarItemPedidosPaginado(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "dataCriacao"));

        return pedidoRepository.findAll(pageRequest)
                .map(pedido -> new ListarPedidoDto(pedido.getId(), pedido.getDataCriacao(), pedido.getStatus(), pedido.getTotal(), pedido.getItens()));
    }
}

