package br.com.ufba.modelo;

import br.com.ufba.interfaces.Command;

public class ConsultarLivroCommand implements Command {
    private BibliotecaFacade facade;
    private int codLivro;

    public ConsultarLivroCommand(BibliotecaFacade facade, int codLivro) {
        this.facade = facade;
        this.codLivro = codLivro;
    }

    @Override
    public void execute() {
        facade.consultarLivro(codLivro);
    }
}
