package src.classesReutilizaveis;

import java.time.LocalDate;

public class Pessoa{

    private String nome;
    private int idade;
    private LocalDate dataNascimento;
    private int telefone=123;
    private static int cont = 0;

    public Pessoa(String nome, int i, int telefone) {
        this.telefone = telefone;
        this.nome = nome;
        idade = i;
        cont++;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        cont++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "nome=\"" + nome + "\"" + ", idade=" + idade + ", telefone=" + telefone;
    }
}
