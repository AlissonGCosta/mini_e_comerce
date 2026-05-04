package br.com.costa.mini_e_comerce.produto.service;

import br.com.costa.mini_e_comerce.produto.dto.request.ProdutoUpdateRequest;
import br.com.costa.mini_e_comerce.produto.dto.response.ListarProdutoDto;
import br.com.costa.mini_e_comerce.produto.dto.response.ProdutoResponse;
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

    public List<ListarProdutoDto> listarProdutos(){

        return iProdutoRepository.findAll()
                .stream()
                .map(prdouto -> ListarProdutoDto.builder()
                        .id(prdouto.getId())
                        .nome(prdouto.getNome())
                        .preco(prdouto.getPreco())
                        .quantidadeEstoque(prdouto.getQuantidadeEstoque())
                        .listaProdutosEmPedido(prdouto.getListaProdutosEmPedido())
                        .build())
                .toList();
    }


    public ProdutoResponse atualizarProduto(UUID id, ProdutoUpdateRequest request){



        ProdutoModel novoProduto = iProdutoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                novoProduto.setNome(request.nome());
                novoProduto.setPreco(request.preco());
                novoProduto.setQuantidadeEstoque(request.estoque());


                ProdutoModel salvoProduto = iProdutoRepository.save(novoProduto);


        return new ProdutoResponse(salvoProduto.getId(), salvoProduto.getNome(), salvoProduto.getPreco(), salvoProduto.getQuantidadeEstoque());
    }

}
