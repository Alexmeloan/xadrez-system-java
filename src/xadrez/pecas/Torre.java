package xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	
		
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0, 0);
		
		//Acima
		p.definirValores(posicao.getLinha() - 1, posicao.getColuna());
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Esquerda
		p.definirValores(posicao.getLinha(), posicao.getColuna() - 1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna( ) - 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
				
		//Direita
		p.definirValores(posicao.getLinha(), posicao.getColuna() + 1);
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna( ) + 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
				}
				
		//Abaixo
		p.definirValores(posicao.getLinha() + 1, posicao.getColuna());
		while(getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if(getTabuleiro().existePosicao(p) && existePeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
				
		return mat;
	}
	
	@Override
	public String toString() {
		return "T";
	}

}
