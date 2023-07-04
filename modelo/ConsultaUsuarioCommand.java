package br.com.ufba.modelo;

import br.com.ufba.interfaces.Command;

public class ConsultaUsuarioCommand implements Command {

    private BibliotecaFacade facade;
    private int codUsuario;

    public ConsultaUsuarioCommand(BibliotecaFacade facade, int codUsuario) {
        this.facade = facade;
        this.codUsuario = codUsuario;
    }

    @Override
    public void execute() {
        facade.consultarUsuario(codUsuario);
    }
}
