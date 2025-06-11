# 📚 Biblioteca Simples em Java - Unifecaf

Este projeto é um CRUD básico de livros feito em **Java**, com interface gráfica utilizando **Swing**. Ele permite adicionar, buscar, remover e listar livros com base no ISBN dos Livros.

---

## 🚀 Funcionalidades

- ✅ Adicionar livros
- 🔍 Buscar livro por ISBN
- ❌ Remover livro
- 📖 Listar todos os livros

> Os dados são armazenados em memória (não utiliza banco de dados).

---

## 🛠️ Tecnologias

- Java (JDK 8 ou superior)
- Swing (para a interface gráfica)
- IDE sugerida: IntelliJ IDEA, Eclipse ou VS Code com extensão Java

---

## 📁 Estrutura do Projeto

📁 src/
├── Livro.java // Classe modelo do livro
├── LivroService.java // CRUD simples em memória
└── Front.java // Interface gráfica com Swing

---

## ▶️ Como Executar

1. Clone o repositório:
git clone https://github.com/seu-usuario/nome-do-repositorio.git

2. Navegue até a pasta do projeto:
cd nome-do-repositorio

3. Compile e execute a aplicação:
```bash
javac Front.java Livro.java Service.java

Você também pode abrir o projeto em uma IDE e executar a classe Front.java diretamente.

📸 Interface Gráfica
A interface permite preencher os dados do livro (ISBN, título, autor) e utilizar botões para executar as ações. Os resultados são exibidos em uma área de texto na mesma janela.
