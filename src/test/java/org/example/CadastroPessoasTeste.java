package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTeste {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarOCadastroDePessoas(){
        //cenário e execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa")
    public void deveAdicionarUmaPessoa(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");

        //execução
        cadastroPessoas.adicionar(pessoa);

        //verificação
        Assertions
                .assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test//(expected = PessoaSemNomeNotException.class)
    @DisplayName("Não deve adicionar Pessoa com nome vazio")
    public void nãoDeveAdicionarPessoaComNomeVazio(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        org.junit.jupiter.api.Assertions
                .assertThrows(PessoaSemNomeNotException.class, () -> cadastroPessoas.adicionar(pessoa) );
    }

    @Test
    @DisplayName("Deve remover uma pessoa")
    public void deveRemoverUmaPessoa(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");
        cadastroPessoas.adicionar(pessoa);

        //execução
        cadastroPessoas.remover(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test//(expected = CadastroVazioException.class)
    @DisplayName("Deve lancar um erro ao tentar remover uma pessoa inexistente")
    public void deveLancarUmErroAoTentarRemoverPessoaInexistente(){
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execucao

        org.junit.jupiter.api.Assertions
                .assertThrows(CadastroVazioException.class, () -> cadastroPessoas.remover(pessoa));


        //verificação

    }
}
