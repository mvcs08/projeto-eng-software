package br.com.ufba.modelo;

import br.com.ufba.interfaces.EstrategiaEmprestimo;

public class AlunoGraducao extends Usuario{
    public AlunoGraducao(int codigo, String nome, EstrategiaEmprestimo estrategiaEmprestimo){
        super(codigo, nome, estrategiaEmprestimo);
        setLimiteDiasEmprestimo(3);
    }
}
