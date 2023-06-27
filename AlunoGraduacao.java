package br.com.ufba.models;

public class AlunoGraduacao extends Usuario{
    private int limiteLivrosEmprestados;
    public AlunoGraduacao(int codigo, String nome){
        setCodigo(codigo);
        setNome(nome);
        setIntervaloEmprestimo(3);
    }
}
