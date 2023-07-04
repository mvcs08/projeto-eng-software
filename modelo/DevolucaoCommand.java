package br.com.ufba.modelo;

import br.com.ufba.interfaces.Command;
public class DevolucaoCommand implements Command {

    private BibliotecaFacade facade;
    private int codUsuario;
    private int codLivro;

    public DevolucaoCommand(BibliotecaFacade facade, int codUsuario, int codLivro) {
        this.facade = facade;
        this.codUsuario = codUsuario;
        this.codLivro = codLivro;
    }

    @Override
    public void execute() {
        facade.devolverLivro(codUsuario, codLivro);
    }
}
