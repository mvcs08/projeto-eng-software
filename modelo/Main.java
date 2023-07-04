package br.com.ufba.modelo;

import br.com.ufba.interfaces.Command;

public class Main {
    public static void main(String[] args) {

        Invoker invocador = new Invoker();
        LeitorDeComandos leitor = new LeitorDeComandos(invocador);

        leitor.lerComandos();
    }
}
