package br.com.ufba.modelo;

import java.util.Arrays;
import java.util.Scanner;

public class LeitorDeComandos {

    private final Invoker invocador;
    public LeitorDeComandos(Invoker invocador) {
        this.invocador = invocador;
        instrucoesDeUso();
    }

    public void instrucoesDeUso() {
        String intrucoes = """
                [ Comandos disponíveis: emp, dev, res, obs, liv, usu, ntf, sai ]
                
                COMO UTILIZAR O SISTEMA:
                emp codigoUsuario codigoLivro -> O usuário realiza o empréstimo do livro.
                dev codigoUsuario codigoLivro -> O usuário devolve um livro emprestado.
                res codigoUsuario codigoLivro -> O usuário realiza a reserva de um exemplar.
                
                CONSULTAS:
                liv codigoLivro -> O sistema apresenta informações sobre o livro.
                usu codigoUsuario -> O sistema apresenta informações sobre o usuário.
                ntf codigoUsuario -> O sistema informa quantas vezes o professor foi notificado.
                sai -> O Sistema é encerrado.
                """;
        System.out.println(intrucoes);
    }

    public void lerComandos() {
        Scanner scanner = new Scanner(System.in);
        String comando;
        int codUsuario = 0;
        int codLivro = 0;

        while (true) {
            System.out.print("console> ");
            comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("sai")) {
                break;
            }

            String[] partes = comando.split(" ");
            System.out.println(Arrays.toString(partes));

            if(partes.length == 2) {
                if(partes[0].equalsIgnoreCase("usu")) {
                    codUsuario = Integer.parseInt(partes[1]);
                }else if(partes[0].equalsIgnoreCase("liv")) {
                    codLivro = Integer.parseInt(partes[1]);
                }
            }
            if (partes.length == 3) {
                codUsuario = Integer.parseInt(partes[1]);
                codLivro = Integer.parseInt(partes[2]);
            }
            /*
            try {
                codUsuario = Integer.parseInt(partes[1]);
                codLivro = Integer.parseInt(partes[2]);
            } catch (NumberFormatException e) {
                System.out.println("Códigos de usuário e livro devem ser números inteiros.");
                continue;
            }*/

            if (partes[0].equalsIgnoreCase("emp")) {
                invocador.executarComando(new EmprestimoCommand(BibliotecaFacade.getInstance(), codUsuario, codLivro));
            } else if(partes[0].equalsIgnoreCase("dev")) {
                invocador.executarComando(new DevolucaoCommand(BibliotecaFacade.getInstance(), codUsuario, codLivro));
            }else if(partes[0].equalsIgnoreCase("res")) {
                invocador.executarComando(new ReservaCommand(BibliotecaFacade.getInstance(),codUsuario, codLivro));
            } else if(partes[0].equalsIgnoreCase("liv")) {
                invocador.executarComando(new ConsultarLivroCommand(BibliotecaFacade.getInstance(), codLivro));
            } else if(partes[0].equalsIgnoreCase("usu")) {
                invocador.executarComando(new ConsultaUsuarioCommand(BibliotecaFacade.getInstance(),codUsuario));
            }
            else {

                System.out.println("Comando inválido e agora");
            }
        }

        scanner.close();
    }


}
