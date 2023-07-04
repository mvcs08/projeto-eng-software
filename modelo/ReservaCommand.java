package br.com.ufba.modelo;

import br.com.ufba.interfaces.Command;

public class ReservaCommand implements Command {
    private BibliotecaFacade facade;
    private int codUsuario;
    private int codLivro;

    public ReservaCommand(BibliotecaFacade facade, int codUsuario, int codLivro) {
        this.facade = facade;
        this.codUsuario = codUsuario;
        this.codLivro = codLivro;
    }

    @Override
    public void execute() {
        facade.reservarLivro(codUsuario, codLivro);
    }
}
