package src.classesReutilizaveis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pessoa {

    private String nome;
    private int idade;
    private LocalDate dataNascimento;
    private int telefone = 123;
    private static int cont = 0;
    public ArrayList<LocalDateTime>alarmes= new ArrayList<>();


    public Pessoa(String nome, int idade, int telefone) {
        this.telefone = telefone;
        this.nome = nome;
        this.idade = idade;
        cont++;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        cont++;
    }

    public Pessoa(String nome, int idade, LocalDate dataNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataNascimento=" + dataNascimento +
                ", telefone=" + telefone +
                ", alarmes=" + alarmes +
                '}';
    }
}