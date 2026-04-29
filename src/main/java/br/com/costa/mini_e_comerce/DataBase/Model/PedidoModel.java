package br.com.costa.mini_e_comerce.DataBase.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Table(name = "pedidos")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;



    @Column(nullable = false, name = "data_criada")
    private LocalDate dataCriacao;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, name = "total_pedido" )
    private Integer totalPedido;


    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedidoModel> itens;

}
