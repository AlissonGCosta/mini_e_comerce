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
}

