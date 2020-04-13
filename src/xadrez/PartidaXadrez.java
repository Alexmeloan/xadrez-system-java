package xadrez;

import java.util.ArrayList;
import java.util.List;

import tabuleirojogo.Peca;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	
	private List<PecaXadrez> pecasNoTabuleiro = new ArrayList<>(); // Lista poderia ter sido criada com a classe ais gen�rica "Peca";
	private List<PecaXadrez> pecasCapturadas = new ArrayList<>();
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		initialSetup();
		}
	
		
	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}


	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez)tabuleiro.peca(i,j);
			}
		}
		return mat;
		
	}
	
	public boolean [][] possiveisMovimentos(PosicaoXadrez posicaoOrigem ){
		Posicao posicao = posicaoOrigem.posicionar();
		validarPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).possiveisMovimentos();
	}
	
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino ) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem,destino);
		Peca capturarPeca = fazerMover(origem, destino);
		proximoTurno();
		return (PecaXadrez)capturarPeca;
	}
	
	private Peca fazerMover(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca capturarPeca = tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, destino);
		
		if (capturarPeca != null) {
			pecasNoTabuleiro.remove(capturarPeca);
			pecasCapturadas.add((PecaXadrez)capturarPeca); //dowcast
		}
		return capturarPeca;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existeUmaPeca(posicao)) {
			throw new XadrezException("j� existe uma pe�a na posi��o de origem");
		}
		 if (jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()) {
			 throw new XadrezException("Ape�a escolhida n�o � sua");
		 }
		 if (!tabuleiro.peca(posicao).existeAlgumMovPossivel()) {
			 throw new XadrezException("N�o existe movimentos poss�veis para a pe�a");
		 }
	
	 } 
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).possivelMovimento(destino)) {
			throw new XadrezException("A pe�a escolhida n�o pode se mover pra posi��o de destino");
		}
			
	}
	
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca ) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).posicionar());
		pecasNoTabuleiro.add(peca);
	}
	
	private void initialSetup() {
		colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	} 

}
