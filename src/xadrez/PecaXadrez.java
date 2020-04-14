package xadrez;

import tabuleirojogo.Peca;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;

public abstract class PecaXadrez extends Peca {
	
	private Cor cor;
	private int contagemMov;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getContagemMov() {
		return contagemMov;
	}
	
	public void aumentarContMov() {
		contagemMov++;
	}
	
	public void diminuirContMov() {
		contagemMov--;
	}
	
	public PosicaoXadrez getPosicaoXadrez() {
		return PosicaoXadrez.apartirDePosicao(posicao);
	}
	
	protected boolean existePeçaOponente(Posicao posicao) {
		PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}

	
	
	

}
