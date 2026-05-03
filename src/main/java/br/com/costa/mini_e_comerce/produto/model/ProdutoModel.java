package br.com.costa.mini_e_comerce.produto.model;

import br.com.costa.mini_e_comerce.item_pedido.model.ItemPedidoModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "produtos")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false, name = "quantidade_em_estoque")
    private Integer quantidadeEstoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemPedidoModel> listaProdutosEmPedido = new ArrayList<>();

    public void  adcionarItemProduto(ItemPedidoModel item) {
        this.listaProdutosEmPedido.add(item);
    }

}
