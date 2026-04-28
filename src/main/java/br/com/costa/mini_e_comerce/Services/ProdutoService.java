package br.com.costa.mini_e_comerce.Services;

import br.com.costa.mini_e_comerce.DataBase.Model.ProdutoModel;
import br.com.costa.mini_e_comerce.DataBase.Model.Repository.IProdutoRepository;
import br.com.costa.mini_e_comerce.DataBase.ModelDto.ProdutoModelDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
