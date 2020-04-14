package xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		if (getCor() == Cor.BRANCO) {
			p.definirValores(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.definirValores(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p) && (getTabuleiro().existePosicao(p2) && !getTabuleiro().existeUmaPeca(p2) && getContagemMov() ==0)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.definirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.definirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
		    }
		
		
	     }
		else {
			p.definirValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.definirValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p) && (getTabuleiro().existePosicao(p2) && !getTabuleiro().existeUmaPeca(p2) && getContagemMov() ==0)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.definirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.definirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
		    }
		}
		   return mat;
	 }
	
	@Override
	public String toString() {
		return "P";
	}
	
}




