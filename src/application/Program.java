package application;


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
		
		while (true) {
			try {
				UI.limparTela();
				UI.printTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lendoPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lendoPosicaoXadrez(sc);
			
			
		PecaXadrez capturarPeca = partidaXadrez.executarMovimentoXadrez(origem, destino);
		
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
