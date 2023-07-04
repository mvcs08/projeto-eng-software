package br.com.ufba.modelo;

import java.util.ArrayList;

public class Livro {
    private int codigo;
    private String titulo;
    private String editora;
    private String autor;
    private int edicao;
    private int anoLancamento;
    private ArrayList<Exemplar> exemplares = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Livro(int codigo, String titulo, String editora, String autor, int edicao, int anoLancamento) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autor = autor;
        this.edicao = edicao;
        this.anoLancamento = anoLancamento;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }
    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public boolean exemplarDisponivel(){
        for(Exemplar e : exemplares) {
            if(e.isStatusDisponibilidade()) return true;
        }
        return false;
    }

    public Exemplar retornarExemplar(){
        for(Exemplar e : exemplares) {
            if (e.isStatusDisponibilidade()){
                return e;
            }
        }
        return null;
    }

    public void dadosLivro() {
        System.out.println("Título: " + getTitulo());
        System.out.println("=================");
        System.out.println("Quantidade de reservas: " + getReservas().size());
        printNomeReservas();
        System.out.println("=================");
        for (Exemplar e : getExemplares())
            e.infoExemplar();

    }
    public void printNomeReservas() {
        System.out.println("Reservado por:");
        for (Reserva r: reservas) {
            System.out.println(r.getUsuario().getNome());
        }
    }
    public Exemplar retornarExemplarEmprestado() {
        for(Exemplar e : exemplares) {
            if (!e.isStatusDisponibilidade()){
                return e;
            }
        }
        return null;
    }

    public int quantidadeExemplarDisponivel(){
        int cont = 0;
        for(Exemplar e : exemplares) {
            if (e.isStatusDisponibilidade())
                cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
