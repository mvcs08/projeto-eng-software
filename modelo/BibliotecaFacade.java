package br.com.ufba.modelo;

import java.util.ArrayList;

public class BibliotecaFacade {
    private static BibliotecaFacade instance;

    private BibliotecaFacade(){
    }

    public static BibliotecaFacade getInstance() {
        if(instance == null) instance = new BibliotecaFacade();

        return instance;
    }

    public static ArrayList<Livro> livros = new ArrayList<>();
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    static {

        livros.add(new Livro(100,"Engenharia de Software", "Addison-Wesley", "Ian Sommervile", 6, 2000));
        livros.add(new Livro(101,"UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", 7, 2000));
        livros.add(new Livro(200,"Code Complete", "Microsoft Press", "Esteve McConnell", 2, 2014));
        livros.add(new Livro(201,"Agile Software Development, Principles, Patterns and Practices ", "Prentice Hall", "Robert Martin", 1, 2002));


        usuarios.add(new AlunoGraducao(123, "João da Silva", new EstrategiaEmprestimoAlunoGraducao()));
        usuarios.add(new AlunoGraducao(789, "Pedro Paulo", new EstrategiaEmprestimoAlunoGraducao()));
        usuarios.add(new Professor(987, "Marcos Vinicius", new EstrategiaEmprestimoProfessor()));

        new Exemplar(buscarLivro(100), 1, true);
        new Exemplar(buscarLivro(100), 2, true);
        new Exemplar(buscarLivro(101), 3, true);
        new Exemplar(buscarLivro(200), 4, true);
        new Exemplar(buscarLivro(201), 5, true);

    }

    public void emprestarLivro(int codUsuario, int codLivro) {
        Usuario u = buscarUsuario(codUsuario);
        Livro l = buscarLivro(codLivro);
        assert u != null;
        assert l != null;

        if(!u.podeFazerEmprestimo(l)) {
            return;
        }else {
            Emprestimo emprestimo = new Emprestimo(u, l, u.getLimiteDiasEmprestimo());
            u.adicionarEmprestimo(emprestimo);
            BibliotecaFacade.emprestimos.add(emprestimo);
            l.retornarExemplar().setStatusDisponibilidade(false);
        }
    }

    public void devolverLivro(int codUsuario, int codLivro) {
        Usuario u = buscarUsuario(codUsuario);
        Livro l = buscarLivro(codLivro);
        assert u != null;
        assert l != null;
        if(u.existeEmprestimoEmAndamento(l)) {
            u.removerLivroEmprestado(l);
            System.out.println(u.getNome() + " o livro: " + l.getTitulo() + ", foi devolvido com sucesso");
        } else {
            System.out.println("Não existe empréstimo ativo para este livro");
        }
    }

    public void consultarLivro(int codLivro) {
        Livro l = buscarLivro(codLivro);
        assert l != null;
        l.dadosLivro();
    }
    public void consultarUsuario(int codUsuario) {
        Usuario u = buscarUsuario(codUsuario);
        assert u != null;
        u.listarEmprestimosAtuais();
        u.listarEmprestimosPassados();
    }

    public void reservarLivro(int codUsuario, int codLivro) {
        Usuario u = buscarUsuario(codUsuario);
        Livro l = buscarLivro(codLivro);
        assert u != null;
        assert l != null;
        if(!u.checarLimiteReservas()) {
            Reserva reserva = new Reserva(u, l);
            u.adicionarReserva(reserva);
            l.adicionarReserva(reserva);
            System.out.println(u.getNome() + " a reserva do livro: " + l.getTitulo() + " foi feita com sucesso");
        } else {
            System.out.println("Você já atingiu o número de reservas");
        }
    }


    private static Livro buscarLivro(int codigo) {
        for(Livro l : livros) {
            if(l.getCodigo() == codigo) {
                return l;
            }
        }
        System.out.println("Não existe livro com este código");
        return null;
    }

    private static Usuario buscarUsuario(int codigo) {
        for(Usuario u : usuarios) {
            if(u.getCodigo() == codigo) {
                return u;
            }
        }
        return null;
    }
}
