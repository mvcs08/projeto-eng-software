package br.com.ufba.modelo;

import java.time.LocalDate;

public class Reserva {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataReserva = LocalDate.now();

    public Reserva(Usuario usuario, Livro livro){
        this.usuario = usuario;
        this.livro = livro;
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
}
