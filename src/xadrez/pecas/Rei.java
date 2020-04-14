package xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	
		
	public boolean podeMover(Posicao posicao){
		 PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		 return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//Acima
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna() );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Abaixo
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna() );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Esquerda
		p.definirValores(posicao.getLinha(), posicao.getColuna() - 1 );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Direita
		p.definirValores(posicao.getLinha(), posicao.getColuna() + 1 );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//NW
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna() - 1 );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//NE
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna() + 1 );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//SW
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna() - 1 );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//SE
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna() + 1 );
		if (getTabuleiro().existePosicao(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	

}
