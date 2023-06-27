package br.com.ufba.models;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataSolicitacao;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Usuario usuario;

    public boolean isAtrasado(){
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.isAfter(dataDevolucao);
    }
}
