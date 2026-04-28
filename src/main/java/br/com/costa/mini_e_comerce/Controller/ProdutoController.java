package br.com.costa.mini_e_comerce.Controller;

import br.com.costa.mini_e_comerce.DataBase.Model.ProdutoModel;
import br.com.costa.mini_e_comerce.DataBase.ModelDto.ProdutoModelDto;
import br.com.costa.mini_e_comerce.Services.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
