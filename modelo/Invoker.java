package br.com.ufba.modelo;

import br.com.ufba.interfaces.Command;

public class Invoker {

    public void executarComando(Command comando) {
        comando.execute();
    }



}
