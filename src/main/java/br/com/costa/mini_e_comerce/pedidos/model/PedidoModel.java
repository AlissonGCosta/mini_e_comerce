package br.com.costa.mini_e_comerce.pedidos.model;

import br.com.costa.mini_e_comerce.cliente.model.ClienteModel;
import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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




    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private ClienteModel cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemPedidoModel> itens = new ArrayList<>();

    public void adcionarItem(ItemPedidoModel item) {
        this.itens.add(item);
    }

}
