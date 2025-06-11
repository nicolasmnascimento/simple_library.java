package br.com.fecaf.model;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public boolean atualizarLivro(String isbn, String novoTitulo, String novoAutor) {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            livro.setTitulo(novoTitulo);
            livro.setAutor(novoAutor);
            return true;
        }
        return false;
    }

    public boolean removerLivro(String isbn) {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            livros.remove(livro);
            return true;
        }
        return false;
    }

    public List<Livro> listarLivros() {
        return livros;
    }
}
