package io.github.lucianodacunha.patterns.extfunction

fun main() {
    print("Entre com o título do livro: ")
    val titulo = "Senhor dos Aneis" // readLine() ?: ""
    print("Entre com o nome do autor: ")
    val autor =  "J. R.R Tolkien" // readLine() ?: ""

    // Aqui usamos a Extension Function "generateSlug()" nas Strings de Entrada.
    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()

    println("Slug gerado para o livro:")
    //TODO: Formatar/Imprimir as slugs considerando o padrão de saída deste desafio.
    println("{${slugTitulo}_${slugAutor}}")
}

// TODO: Lógica para que qualquer String tenha a capacidade de gerar uma slug (seguindo-este-padrao).
fun String.generateSlug()= this.replace("(\\. )|[^a-zA-Z0-9]".toRegex(), "-").lowercase()
