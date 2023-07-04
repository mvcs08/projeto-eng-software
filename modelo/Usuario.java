package br.com.ufba.modelo;

import br.com.ufba.interfaces.EstrategiaEmprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public abstract class Usuario {

    private int codigo;
    private String nome;
    private ArrayList<Emprestimo> emprestimosAtuais = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimosPassados = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private EstrategiaEmprestimo estrategiaEmprestimo;
    private int limiteDiasEmprestimo;
    private boolean limiteReservas = false;

    public Usuario(int codigo, String nome, EstrategiaEmprestimo estrategiaEmprestimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.estrategiaEmprestimo = estrategiaEmprestimo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLimiteDiasEmprestimo() {
        return limiteDiasEmprestimo;
    }

    public void setLimiteDiasEmprestimo(int limiteDiasEmprestimo) {
        this.limiteDiasEmprestimo = limiteDiasEmprestimo;
    }

    public ArrayList<Emprestimo> getEmprestimosAtuais() {
        return emprestimosAtuais;
    }

    public ArrayList<Emprestimo> getEmprestimosPassados() {
        return emprestimosPassados;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimosAtuais.add(emprestimo);
    }

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        if(reservas.size() >= 3){
            limiteReservas = true;
        }
    }

    public boolean podeFazerEmprestimo(Livro livro) {
        return estrategiaEmprestimo.podeFazerEmprestimo(this, livro);
    }
    public boolean isDevedor(){
        for(Emprestimo e : emprestimosAtuais) {
            if(e.isAtrasado()) {
                return true;
            }
        }
        return false;
    }

    public boolean existeReserva(Livro livro){
        for(Reserva r : reservas) {
            if(r.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeEmprestimoEmAndamento(Livro livro) {
        for(Emprestimo e : emprestimosAtuais) {
            if(e.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public void removerLivroEmprestado(Livro livro){
        for(Emprestimo e : emprestimosAtuais) {
            if(e.getLivro().equals(livro)) {
                e.setDevolvido(true);
                e.setDataDevolucao(LocalDate.now());
                emprestimosPassados.add(e);
                emprestimosAtuais.remove(e);
                e.getLivro().retornarExemplarEmprestado().setStatusDisponibilidade(true);
                break;
            }
        }
    }

    public void listarEmprestimosAtuais() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Emprestimos atuais: ");
        for(Emprestimo e : getEmprestimosAtuais()) {
            System.out.print(e.getLivro().getTitulo() +": "+"Emprestado dia: " + e.getDataEmprestimo().format(formatters));
            System.out.println(" - Em curso - Data de devolução prevista: " + e.getDataDevolucao().format(formatters));
        }
    }

    public void listarEmprestimosPassados(){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Emprestimos passados: ");
        for(Emprestimo e : getEmprestimosPassados()) {
            System.out.print(e.getLivro().getTitulo() +": "+"Emprestado dia: " + e.getDataEmprestimo().format(formatters));
            System.out.println(" - Devolvido - Data de devolução: " + e.getDataDevolucao().format(formatters));
        }
    }
    public boolean checarLimiteReservas() {
        return this.limiteReservas;
    }
}


