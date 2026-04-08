package com.ym.prova.services;


import com.ym.prova.models.ProdutoModel;
import com.ym.prova.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> listarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoModel atualizarProduto(Long id,ProdutoModel produtoModel){
        ProdutoModel produto =  produtoRepository.findById(id).get();
        produto.setNome(produtoModel.getNome());
        produto.setDescricao(produtoModel.getDescricao());
        produto.setPreco(produtoModel.getPreco());
        return produtoRepository.save(produto);
    }

    public void excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }

}
