package JogoVelha;

public class Jogador{
    private String nome;
    private char simbolo;

    public Jogador(String nome, char simbolo){
        this.setNome(nome);
        this.setSimbolo(simbolo);
    }

    public void setSimbolo(char simbolo){
        this.simbolo = simbolo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public char getSimbolo(){
        return this.simbolo;
    }
}