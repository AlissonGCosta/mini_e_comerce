package br.com.costa.mini_e_comerce.item_pedido.model;

import br.com.costa.mini_e_comerce.pedidos.model.PedidoModel;
import br.com.costa.mini_e_comerce.produto.model.ProdutoModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "item_pedido")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ItemPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false, name = "sub_total")
    private BigDecimal subTotal;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoModel pedido;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoModel produto;



}
