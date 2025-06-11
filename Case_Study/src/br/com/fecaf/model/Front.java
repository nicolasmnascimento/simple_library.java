package br.com.fecaf.model;

import javax.swing.*;
import java.awt.*;

public class Front extends JFrame {

    private Service service = new  Service();

    private JTextField txtIsbn = new JTextField(10);
    private JTextField txtTitulo = new JTextField(10);
    private JTextField txtAutor = new JTextField(10);
    private JTextArea areaResultado = new JTextArea(8, 25);

    public Front() {
        super("Biblioteca Simples");

        setLayout(new FlowLayout());

        add(new JLabel("ISBN:"));
        add(txtIsbn);
        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Autor:"));
        add(txtAutor);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnRemover = new JButton("Remover");
        JButton btnListar = new JButton("Listar");

        add(btnAdicionar);
        add(btnBuscar);
        add(btnRemover);
        add(btnListar);

        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado));

        btnAdicionar.addActionListener(e -> {
            if (camposValidos()) {
                service.adicionarLivro(new Livro(txtIsbn.getText(), txtTitulo.getText(), txtAutor.getText()));
                areaResultado.setText("Livro adicionado!");
                limparCampos();
            } else {
                areaResultado.setText("Preencha todos os campos.");
            }
        });

        btnBuscar.addActionListener(e -> {
            String isbn = txtIsbn.getText();
            if (isbn.isEmpty()) {
                areaResultado.setText("Informe o ISBN para buscar.");
                return;
            }
            Livro livro = service.buscarLivro(isbn);
            if (livro != null) {
                areaResultado.setText(formatarLivro(livro));
                preencherCampos(livro);
            } else {
                areaResultado.setText("Livro não encontrado.");
            }
        });

        btnRemover.addActionListener(e -> {
            String isbn = txtIsbn.getText();
            if (isbn.isEmpty()) {
                areaResultado.setText("Informe o ISBN para remover.");
                return;
            }
            boolean ok = service.removerLivro(isbn);
            areaResultado.setText(ok ? "Livro removido!" : "Livro não encontrado.");
            if (ok) limparCampos();
        });

        btnListar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Livro l : service.listarLivros()) {
                sb.append(formatarLivro(l)).append("\n");
            }
            areaResultado.setText(sb.length() == 0 ? "Nenhum livro cadastrado." : sb.toString());
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean camposValidos() {
        return !txtIsbn.getText().isEmpty() && !txtTitulo.getText().isEmpty() && !txtAutor.getText().isEmpty();
    }

    private void limparCampos() {
        txtIsbn.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
    }

    private void preencherCampos(Livro livro) {
        txtIsbn.setText(livro.getIsbn());
        txtTitulo.setText(livro.getTitulo());
        txtAutor.setText(livro.getAutor());
    }

    private String formatarLivro(Livro livro) {
        return "Livro [ISBN: " + livro.getIsbn() + ", Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + "]";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Front::new);
    }
}