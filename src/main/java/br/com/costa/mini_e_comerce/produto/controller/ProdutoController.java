package br.com.costa.mini_e_comerce.produto.controller;

import br.com.costa.mini_e_comerce.produto.model.ProdutoModel;
import br.com.costa.mini_e_comerce.produto.service.ProdutoService;
import br.com.costa.mini_e_comerce.produto.dto.request.ProdutoModelDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public void criarProduto(@Valid @RequestBody ProdutoModelDto produtoModelDto) {
        produtoService.createProduto(produtoModelDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel atualizarProduto(@PathVariable UUID id, @Valid @RequestBody ProdutoModelDto produtoModel) {
        return produtoService.alterarProduto(id, produtoModel);
    }
}
