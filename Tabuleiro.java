package JogoVelha;

public class Tabuleiro{
    private static final int TAMANHO = 3;
    private char[][] local;

    public Tabuleiro(){
        this.local = new char[TAMANHO][TAMANHO];
        this.iniciaTabuleiro();
    }

    public void iniciaTabuleiro(){
        for(int i=0; i<TAMANHO; i++){
            for(int j=0; j<TAMANHO; j++){
                this.local[i][j] = '-';
            }
        }
    }

    public void exibeTabuleiro(){
        System.out.println("-------------");
        for(int i=0; i<TAMANHO; i++){
            System.out.print("| ");
            for(int j=0; j<TAMANHO; j++){
                System.out.print(this.local[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public boolean validarIntervaloValores(int linha, int coluna){
        if(linha < 1 || linha > 3 || coluna < 1 || coluna > 3){
            return false;
        }
        return true;
    }

    public boolean validarPosicao(int linha, int coluna){
        if(this.local[linha][coluna] != '-'){
            return false;
        }
        return true;
    }

    public void alterarTabuleiro(char simbolo, int linha, int coluna){
        this.local[linha][coluna] = simbolo;
    }

    public boolean validarVitoria(char simbolo){
        for(int i=0; i<TAMANHO; i++){
            if((this.local[i][0] == simbolo && this.local[i][1] == simbolo  && this.local[i][2] == simbolo) ||
                (this.local[0][i] == simbolo && this.local[1][i] == simbolo && this.local[2][i] == simbolo)){
                    return true;
            }
        }
        if((this.local[0][0] == simbolo && this.local[1][1] == simbolo  && this.local[2][2] == simbolo) ||
            (this.local[0][2] == simbolo && this.local[1][1] == simbolo  && this.local[2][0] == simbolo)){
                return true;
        }
        return false;
    }

    public boolean validarTabuleiroCheio(){
        int count = 0;
        for(int i=0; i<TAMANHO; i++){
            for(int j=0; j<TAMANHO; j++){
                if(this.local[i][j] == '-')
                    count++;
            }
        }
        if(count == 0)
            return false;
        else
            return true;
    }
    public void apresentacao(Jogador jogador1, Jogador jogador2){
        System.out.println("Bem-vindo ao jogo da Velha");
        System.out.println(jogador1.getNome() + " jogará de " + jogador1.getSimbolo());
        System.out.println(jogador2.getNome() + " jogará de " + jogador2.getSimbolo());
        System.out.println();
    }

    public void localUtilizado(){
        System.out.println("-------------------------------");
        System.out.printf("Local informado já está utilizado.\nEscolha outros valores\n");
        System.out.println("-------------------------------");
    }
    public void localIncorreto(){
        System.out.println("-------------------------------");
        System.out.println("Digite valores iguais a 1, 2 ou 3");
        System.out.println("-------------------------------");
    }
    public void anunciarVencedor(String nome){
        System.out.println("-------------------------------");
        System.out.println("O " + nome + " venceu. Parabéns!!");
        System.out.println("-------------------------------");
    }
    public void partidaEmpatada(){
        System.out.println("-------------------------------");
        System.out.println("Partida empatada");
        System.out.println("-------------------------------");
    }
}