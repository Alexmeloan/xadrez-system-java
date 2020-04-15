package xadrez.pecas;

import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
	
	//private PartidaXadrez partidaXadrez;

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		//this.partidaXadrez = partidaXadrez;
		
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
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p) && getTabuleiro().existePosicao(p2) && !getTabuleiro().existeUmaPeca(p2) && getContagemMov() ==0) {
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
			
			// #specialmove en passant white
		/*	if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}*/
				
	     }
		else {
			p.definirValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.definirValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p) && getTabuleiro().existePosicao(p2) && !getTabuleiro().existeUmaPeca(p2) && getContagemMov() ==0) {
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
			
			// #specialmove en passant black
				/*		if (position.getRow() == 4) {
							Position left = new Position(position.getRow(), position.getColumn() - 1);
							if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
								mat[left.getRow() + 1][left.getColumn()] = true;
							}
							Position right = new Position(position.getRow(), position.getColumn() + 1);
							if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
								mat[right.getRow() + 1][right.getColumn()] = true;
							}
						}			
					}*/
		}
		   return mat;
	 }
	
	@Override
	public String toString() {
		return "P";
	}
	
}




