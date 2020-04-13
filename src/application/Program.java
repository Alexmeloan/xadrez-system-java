package application;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tabuleirojogo.TabuleiroException;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> capturada =  new ArrayList<>();
		
		while (true) {
			try {
				UI.limparTela();
				UI.printJogador(partidaXadrez, capturada);
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lendoPosicaoXadrez(sc);
				
				boolean[][] possiveisMovimentos = partidaXadrez.possiveisMovimentos(origem);
				UI.limparTela();
				UI.printTabuleiro(partidaXadrez.getPecas(), possiveisMovimentos);
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lendoPosicaoXadrez(sc);
			
			
		PecaXadrez capturarPeca = partidaXadrez.executarMovimentoXadrez(origem, destino);
		
		if (capturarPeca != null) {
			capturada.add(capturarPeca);
		}
			}
           catch(XadrezException e) {
        	 System.out.println(e.getMessage());	
        	 sc.nextLine();
			}
			catch(TabuleiroException e) {
	        	 System.out.println(e.getMessage());	
	        	 sc.nextLine();
				}
		}

	}

}
