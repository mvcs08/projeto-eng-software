package br.com.ufba.modelo;

import java.time.format.DateTimeFormatter;

public class Exemplar {
    private Livro livro;
    private int codigo;
    private boolean statusDisponibilidade;

    public Exemplar(Livro livro, int codigo, boolean statusDisponibilidade) {
        this.livro = livro;
        this.codigo = codigo;
        this.statusDisponibilidade = statusDisponibilidade;
        this.livro.adicionarExemplar(this);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isStatusDisponibilidade() {
        return statusDisponibilidade;
    }

    public void setStatusDisponibilidade(boolean statusDisponibilidade) {
        this.statusDisponibilidade = statusDisponibilidade;
    }

    public void infoExemplar() {
        System.out.print("Código: " + this.codigo + " - ");
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (statusDisponibilidade) {
            System.out.println("Disponível");
        } else {
            System.out.print("Emprestado a: ");
            for(Emprestimo e : BibliotecaFacade.emprestimos) {
                if(!e.isDevolvido() && e.getLivro().getExemplares().contains(this)) {
                    if(BibliotecaFacade.usuarios.contains(e.getUsuario())) {
                        System.out.print(e.getUsuario().getNome());
                        System.out.print(" em " + e.getDataEmprestimo().format(formatters));
                        System.out.println(" até " + e.getDataDevolucao().format(formatters));
                    };

                }
            }
        }
    }
}
