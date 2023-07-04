package br.com.ufba.modelo;

import br.com.ufba.interfaces.EstrategiaEmprestimo;

public class AlunoPosGraduacao extends Usuario{

    public AlunoPosGraduacao(int codigo, String nome, EstrategiaEmprestimo estrategiaEmprestimo) {
        super(codigo, nome, estrategiaEmprestimo);
        setLimiteDiasEmprestimo(4);
    }
}
