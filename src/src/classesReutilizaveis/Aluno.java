package src.classesReutilizaveis;

public class Aluno extends Pessoa{

    int nmac;

    public Aluno(String nome, int i, int telefone, int nmac) {
        super(nome, i, telefone);
        this.nmac = nmac;
    }

    @Override
    public String toString() {
        return super.toString()+" nmac: "+nmac;
    }
}
