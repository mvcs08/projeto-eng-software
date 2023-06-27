package br.com.ufba.models;

public class AlunoPosGraduacao extends Usuario{
    private int limiteLivrosEmprestados;
    public AlunoPosGraduacao(int codigo, String nome){
        setCodigo(codigo);
        setNome(nome);
        setIntervaloEmprestimo(4);
    }
}
