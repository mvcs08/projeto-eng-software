package br.com.ufba.models;

public class TesteBiblioteca {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        int i = 0;
        for(Livro l : biblioteca.getLivros()) {
            System.out.println(biblioteca.getLivros().get(i).getTitulo() + " - " +biblioteca.getLivros().get(i).getAutores());
            i++;
        }

        biblioteca.realizarEmprestimo(123, 100);

    }
}
