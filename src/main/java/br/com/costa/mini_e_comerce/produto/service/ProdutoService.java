package br.com.costa.mini_e_comerce.produto.service;

import br.com.costa.mini_e_comerce.produto.model.ProdutoModel;
import br.com.costa.mini_e_comerce.produto.dto.request.ProdutoModelDto;
import br.com.costa.mini_e_comerce.produto.repository.IProdutoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final IProdutoRepository iProdutoRepository;

    public void createProduto(@Valid ProdutoModelDto produtoDto){

        iProdutoRepository.save(ProdutoModel.builder()
                        .nome(produtoDto.getNome())
                        .preco(produtoDto.getPreco())
                        .quantidadeEstoque(produtoDto.getQuantidadeEstoque())
                .build());
    }

    public List<ProdutoModel> listarProdutos(){

        return iProdutoRepository.findAll();
    }


    public ProdutoModel alterarProduto(UUID id, ProdutoModelDto produtoDto){



        ProdutoModel novoProduto = iProdutoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                novoProduto.setNome(produtoDto.getNome());
                novoProduto.setPreco(produtoDto.getPreco());
                novoProduto.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());


        return iProdutoRepository.save(novoProduto) ;
    }

}
