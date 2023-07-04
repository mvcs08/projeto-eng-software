package br.com.ufba.interfaces;

import br.com.ufba.modelo.Livro;
import br.com.ufba.modelo.Usuario;

public interface EstrategiaEmprestimo {

    boolean podeFazerEmprestimo(Usuario usuario, Livro livro);
}
