package br.com.ufba.modelo;

import br.com.ufba.interfaces.EstrategiaEmprestimo;

public class EstrategiaEmprestimoAlunoGraducao implements EstrategiaEmprestimo {
    private static final int LIMITE_EMPRESTIMO = 3;
    @Override
    public boolean podeFazerEmprestimo(Usuario usuario, Livro livro) {
        // regra (i)
        if(!livro.exemplarDisponivel()){
            System.out.println("Não existe exemplares deste livro disponível");
            return false;
        }

        // regra (ii)
        if(usuario.isDevedor()){
            System.out.println("O empréstimo não pôde ser feito pois o usuário está com pendência");
            return false;
        }

        // regra(iii)
        if(usuario.getEmprestimosAtuais().size() >= LIMITE_EMPRESTIMO){
            System.out.println("Usuário já atingiu o limite de empréstimos em aberto");
            return false;
        }
        // regra(vi)
        if(usuario.existeEmprestimoEmAndamento(livro)){
            System.out.println("Já existe empréstimo ativo para este livro");
            return false;
        }

        /* todo:
        * implementar verificaççoes (iv) e (v)
        * */
        System.out.println(usuario.getNome() + " o empréstimo do livro: " + livro.getTitulo() + " foi realizado com sucesso");
        return true;
    }
}
