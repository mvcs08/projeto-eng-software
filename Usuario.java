package br.com.ufba.models;
import java.util.List;
public abstract class Usuario {

    private int codigo;
    private String nome;
    private int intervaloEmprestimo;
    private boolean devedor = false;
    private List<Reserva> reservas;
    private List<Emprestimo> emprestimos;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIntervaloEmprestimo() {
        return intervaloEmprestimo;
    }

    protected  void setIntervaloEmprestimo(int intervaloEmprestimo) {
        this.intervaloEmprestimo = intervaloEmprestimo;
    }

    public boolean isDevedor() {
        for(Emprestimo e : emprestimos) {
            if(e.isAtrasado()) {
                return true;
            }
        }
        return devedor;
    }
}
