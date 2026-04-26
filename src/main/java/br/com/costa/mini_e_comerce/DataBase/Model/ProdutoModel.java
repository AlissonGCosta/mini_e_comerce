package br.com.costa.mini_e_comerce.DataBase.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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

    @OneToMany(mappedBy = "produto")
    private List<ItemPedidoModel> itens;

}
