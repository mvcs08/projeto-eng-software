package br.com.ufba.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private static List<Livro> livros = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new AlunoGraduacao(123,"João da Silva"));
        usuarios.add(new AlunoPosGraduacao(456, "Luiz Fernando Rodrigues"));
        usuarios.add(new AlunoGraduacao(789,"Pedro Paulo"));
        usuarios.add(new Professor(100,"Carlos Lucena"));

        livros.add(new Livro(100, "Engenharia de Software", "AddisonWesley", Collections.singletonList("Ian Sommervile"), 6, 2000));
        livros.add(new Livro(101,"UML - Guia do Usuário", "Campus", Arrays.asList("Grady Booch", "James Rumbaugh", "Ivar Jacobson"), 7, 2000));
        livros.add(new Livro(200,"Code complete", "Microsoft Press", Collections.singletonList("Steve McConnell"), 2, 2014));
        livros.add(new Livro(201,"Agile Software Development, Principles, Patterns, and Pratices", "Prentice Hall", Collections.singletonList("Robert Martin"), 1, 2002));
        livros.add(new Livro(300, "Refactoring: Improving the Design of Existing Code", "Adisson-Wesley Professional", Collections.singletonList("Martin Fowler"), 1, 1999));


    }
    public List<Livro> getLivros() {
        return livros;
    }
    public void realizarEmprestimo(int codigoUsuario, int codigoLivro) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        Livro livro = buscarLivro(codigoLivro);

    }

    private Usuario buscarUsuario(int codigo) {
        for(Usuario u : usuarios) {
            if(u.getCodigo() != codigo) {
                return u;
            }
        }
        return null;
    }

    private Livro buscarLivro(int codigo) {
        for(Livro l : livros) {
            if(l.getCodigo() == codigo) {
                return l;
            }
        }
        return null;
    }
}
