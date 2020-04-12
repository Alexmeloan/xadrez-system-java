package xadrez;

import tabuleirojogo.Posicao;

public class PosicaoXadrez {
	
	private char coluna;
	private int linha;
	
	
	
	public PosicaoXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro ao instanciar o PosicaoXadrez. Os valores v�lidos s�o de a1 a h8"); 
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	
	
	public char getColuna() {
		return coluna;
	}


	public int getLinha() {
		return linha;
	}


	protected Posicao posicionar() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	protected static PosicaoXadrez apartirDePosicao(Posicao posicao) {
		return new PosicaoXadrez ((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}


	
	
	

}