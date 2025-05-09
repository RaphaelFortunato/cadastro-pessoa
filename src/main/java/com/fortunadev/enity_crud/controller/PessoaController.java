package com.fortunadev.enity_crud.controller;

import com.fortunadev.enity_crud.exception.PessoaNotFoundException;
import com.fortunadev.enity_crud.model.Pessoa;
import com.fortunadev.enity_crud.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public String listaPessoas(Model model){
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        model.addAttribute("listaPessoas", pessoas);
        return "/lista-pessoas";
    }

    @GetMapping("/novoCadastro")
    public String novoCadastro(Model model){
        Pessoa pessoa = new Pessoa();
        model.addAttribute("novoCadastro", pessoa);
        return "/novo-cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("novoCadastro") @Valid Pessoa pessoa,
                         BindingResult erros, RedirectAttributes attributes){
        if(erros.hasErrors()){
            return "/novo-cadastro";//retornando para página
        }
        pessoaService.salvar(pessoa);
        attributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso!");

        return "redirect:/novoCadastro";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable("id") Long id, RedirectAttributes attributes ){
        try {
            pessoaService.deletarPessoa(id);
        } catch (PessoaNotFoundException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editarPessoa(@PathVariable("id") Long id, RedirectAttributes attributes, Model model){
        try {
            Pessoa pessoa = pessoaService.buscaPessoaId(id);
            model.addAttribute("objetoPessoa", pessoa);
            return "/editar-pessoa";
        } catch (PessoaNotFoundException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping("/editar/{id}")
    public String editarSalvarPessoa(@PathVariable("id") Long id, @ModelAttribute("objetoPessoa")
                                     @Valid Pessoa pessoa, BindingResult erros){
        if(erros.hasErrors()){
            pessoa.setId(id);
            return "/editar-pessoa";
        }
        pessoaService.alterarPessoa(pessoa);
        return "redirect:/";
    }

    @PostMapping("/buscar")
    public String buscarPessoaPorDescricao(Model model, @Param("nome") String nome ){
        if(nome == null){
            return "redirect:/";
        }
        List<Pessoa> pessoas = pessoaService.buscarPessoasPorNome(nome);
        model.addAttribute("listaPessoas", pessoas);
        return "/lista-pessoas";
    }

}
