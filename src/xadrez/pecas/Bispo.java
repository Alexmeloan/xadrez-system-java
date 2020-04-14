package xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Bispo extends PecaXadrez {

	public Bispo (Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
		
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//NW
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna() -1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() - 1, p.getColuna() - 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//NE
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() - 1, p.getColuna() + 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
				
		//SE
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() + 1, p.getColuna() + 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
				}
				
		//SW
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.definirValores(p.getLinha() + 1, p.getColuna() - 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
				
		return mat;
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
