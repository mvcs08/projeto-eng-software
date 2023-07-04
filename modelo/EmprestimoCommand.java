package br.com.ufba.modelo;

import br.com.ufba.interfaces.Command;

public class EmprestimoCommand implements Command {
    private BibliotecaFacade facade;
    private int codUsuario;
    private int codLivro;

    public EmprestimoCommand(BibliotecaFacade facade, int codUsuario, int codLivro) {
        this.facade = facade;
        this.codUsuario = codUsuario;
        this.codLivro = codLivro;
    }

    public void execute() {
        facade.emprestarLivro(codUsuario, codLivro);
    }
}
