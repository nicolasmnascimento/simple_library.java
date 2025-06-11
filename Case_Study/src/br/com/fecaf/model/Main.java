package br.com.fecaf.model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        // 1. Adicionar livros
        service.adicionarLivro(new Livro("111", "Java Básico", "Autor A"));
        service.adicionarLivro(new Livro("222", "Spring Framework", "Autor B"));

        // 2. Listar todos
        System.out.println("Lista inicial:");
        for (Livro l : service.listarLivros()) {
            System.out.println(formatarLivro(l));
        }

        // 3. Buscar livro por ISBN
        System.out.println("\nBuscando livro com ISBN 111:");
        Livro encontrado = service.buscarLivro("111");
        System.out.println(encontrado != null ? formatarLivro(encontrado) : "Livro não encontrado.");

        // 4. Atualizar livro
        boolean atualizado = service.atualizarLivro("111", "Java Avançado", "Autor A");
        System.out.println("\nAtualização do livro 111: " + (atualizado ? "Sucesso" : "Falha"));

        // 5. Remover livro
        boolean removido = service.removerLivro("222");
        System.out.println("Remoção do livro 222: " + (removido   ? "Sucesso" : "Falha"));

        // 6. Listar livros após alterações
        System.out.println("\nLista final:");
        for (Livro l : service.listarLivros()) {
            System.out.println(formatarLivro(l));
        }
    }

    private static String formatarLivro(Livro livro) {
        return "Livro [ISBN: " + livro.getIsbn() + ", Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + "]";
    }
}