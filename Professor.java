package br.com.ufba.models;

public class Professor extends Usuario{

    public Professor(int codigo, String nome) {
        setCodigo(codigo);
        setNome(nome);
        setIntervaloEmprestimo(7);
    }
}
