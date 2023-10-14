package JogoVelha;

import java.util.Scanner;

public class Jogo{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Jogador jogador1 = new Jogador("Jogador 1", 'X');
        Jogador jogador2 = new Jogador("Jogador 2", 'O');
        Jogador jogadorAtual = jogador1;
        Tabuleiro tabuleiro = new Tabuleiro();

        boolean situacaoJogo = false;
        int linha, coluna;

        tabuleiro.apresentacao(jogador1, jogador2);
        
        while (!situacaoJogo){
            tabuleiro.exibeTabuleiro();
            System.out.println(jogadorAtual.getNome() + " Sua vez.");

            System.out.print("Linha(1, 2 ou 3): ");
            linha = scan.nextInt();

            System.out.print("Coluna(1, 2 ou 3): ");
            coluna = scan.nextInt();

            if(tabuleiro.validarIntervaloValores(linha, coluna)){
                linha--;
                coluna--;
                if(tabuleiro.validarPosicao(linha, coluna)){
                    tabuleiro.alterarTabuleiro(jogadorAtual.getSimbolo(), linha, coluna);
                    if(!tabuleiro.validarTabuleiroCheio()){
                        tabuleiro.exibeTabuleiro();
                        tabuleiro.partidaEmpatada();
                        situacaoJogo = true;
                    }
                    if(tabuleiro.validarVitoria(jogadorAtual.getSimbolo())){
                        tabuleiro.anunciarVencedor(jogadorAtual.getNome());
                        situacaoJogo = true;
                    }else {
                        jogadorAtual = (jogadorAtual == jogador1)? jogador2 : jogador1;
                    }
                } else {
                    tabuleiro.localUtilizado();
                }
            }else{
                tabuleiro.localIncorreto();
            }
        }
        scan.close();
    }
}