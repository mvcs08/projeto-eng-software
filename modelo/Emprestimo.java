package br.com.ufba.modelo;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo = LocalDate.now();
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Usuario u, Livro l, int dias) {
        this.usuario = u;
        this.livro = l;
        this.dataDevolucao = this.dataEmprestimo.plusDays(dias);
        devolvido = false;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean isDevolvido() {
        return devolvido;
    }

    public boolean isAtrasado() {
        return LocalDate.now().isAfter(dataDevolucao);
    }

    public void setDevolvido(boolean b) {
        devolvido = true;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
