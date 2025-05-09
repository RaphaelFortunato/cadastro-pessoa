package com.fortunadev.enity_crud.service;

import com.fortunadev.enity_crud.exception.PessoaNotFoundException;
import com.fortunadev.enity_crud.model.Pessoa;
import com.fortunadev.enity_crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Pessoa buscaPessoaId(Long id) throws PessoaNotFoundException{
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if(optionalPessoa.isPresent()){
            return optionalPessoa.get();
        }else {
            throw new PessoaNotFoundException("Pessoa com id: " + id + " não existe!");
        }
    }

    //opção 2
    public Optional<Pessoa> buscarId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void deletarPessoa(Long id) throws PessoaNotFoundException{
        Pessoa pessoa = buscaPessoaId(id);
        pessoaRepository.delete(pessoa);
    }

    public Pessoa alterarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> buscarPessoasPorNome(String nome){
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }



}
