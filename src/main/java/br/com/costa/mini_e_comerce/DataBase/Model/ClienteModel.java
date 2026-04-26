package br.com.costa.mini_e_comerce.DataBase.Model;


import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.UUID;

@Table(name = "clientes")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteModel {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoModel> pedidos;


}
