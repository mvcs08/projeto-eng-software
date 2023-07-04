package br.com.ufba.modelo;

import br.com.ufba.interfaces.EstrategiaEmprestimo;
public class Professor extends Usuario{
    public Professor(int codigo, String nome, EstrategiaEmprestimo estrategiaEmprestimo){
        super(codigo, nome, estrategiaEmprestimo);
        setLimiteDiasEmprestimo(7);
    }
}
