package br.com.ufba.modelo;

import br.com.ufba.interfaces.EstrategiaEmprestimo;

public class EstrategiaEmprestimoProfessor implements EstrategiaEmprestimo {
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
        System.out.println("Professor seu livro foi reservado com sucesso");
        return true;
    }
}
