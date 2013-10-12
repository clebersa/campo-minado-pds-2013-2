package model;

/**
 * Define os atributos e métodos de um tabuleiro.
 *
 * @author Cleber, Samuel
 */
public class Tabuleiro implements Exibivel {

	/**
	 * Tipo do tabuleiro.
	 *
	 * @see model.TipoTabuleiro
	 */
	private TipoTabuleiro tipoTabuleiro;
	/**
	 * Matriz de quadrados que formam o tabuleiro.
	 */
	private Quadrado[][] quadrados;
	/**
	 * Distribuidor de minas.
	 */
	private DistribuidorMinas distribuidorMinasInterface;

	/**
	 * Constrói um novo tabuleiro com base no tipo recebido.
	 *
	 * @param tipo Tipo do tabuleiro.
	 */
	public void Tabuleiro(TipoTabuleiro tipo) {
		/*
		 * Após identificar qual é o tipo, inicializa o tabuleiro, 
		 * distribui as minas e, por fim, regula o tabuleiro com os números 
		 * indicadores de minas na vizinhança.
		 */
	}

	/**
	 * Executa uma jogada no tabuleiro.
	 *
	 * @param jogada Jogada a ser executada no tabuleiro.
	 * @return <code>FALSE</code> caso a jogada
	 * seja <code>TipoJogada.ABRIR</code> e o quadrado continha uma mina,
	 * ou <code>TRUE</code> para jogadas do tipo <code>TipoJogada.MARCAR</code>
	 * e/ou com o quadrado não continha mina.
	 */
	public boolean executarJogada(Jogada jogada) {
		boolean resultado;
		if (jogada.isABRIR()) {
			resultado = abrirQuadrado(jogada.getLinha(), jogada.getColuna());
		} else if (jogada.isMARCAR()) {
			marcarQuadrado(jogada.getLinha(), jogada.getColuna());
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Inicializa o tabuleiro com quadrados vazios.
	 */
	private void inicializarTabuleiro() {
		//com base nas dimensões, criar quadrados e colocá-los na matriz
	}

	/**
	 * Distribui as minas pelo tabuleiro.
	 */
	private void distribuirMinas() {
		//usar a distribuição pela interface.
	}

	/**
	 * Para todos os quadrados do tabuleiro, contabiliza o número de minas que
	 * há na vizinhança.
	 */
	private void contabilizarMinasVizinhas() {
		//criar um laço de repetição e, para cada quadrado, chamar o método abaixo
	}

	/**
	 * Para um quadrado específico, contabiliza a quantidade de minas que há na
	 * vizinhança.
	 *
	 * @param linha Número da linha onde o quadrado está localizado no
	 * tabuleiro.
	 * @param coluna Número da coluna onde o quadrado está localizado no
	 * tabuleiro.
	 */
	private void contabilizarMinasVizinhasQuadrado(int linha, int coluna) {
		//contabilizar os vizinhos
	}

	/**
	 * Abre um quadrado.
	 *
	 * @param linha Número da linha onde o quadrado está localizado no
	 * tabuleiro.
	 * @param coluna Número da coluna onde o quadrado está localizado no
	 * tabuleiro.
	 * @return <code>FALSE</code>, caso o quadrado contenha uma mina; ou
	 * <code>TRUE</code>, caso contrário.
	 */
	private boolean abrirQuadrado(int linha, int coluna) {
		boolean resultado = false;
		try {
			if (quadrados[linha][coluna].isAberto()) {
				resultado = true;
			}
		} catch (IndexOutOfBoundsException excecao) {
			resultado = true;
		}
		if (!resultado) {
			TipoConteudo tipoConteudo;
			tipoConteudo = quadrados[linha][coluna].abrir();
			if (tipoConteudo.isMINA()) {
				resultado = false;
			} else if(tipoConteudo.isNUMERO()){
				resultado = true;
			}else{
				linha -= 1;
				coluna -= 1;
				for (int counter = 0; counter < 3; counter++, coluna++) {
					abrirQuadrado(linha, coluna);
				}
				linha++;
				coluna--;
				for (int counter = 0; counter < 2; counter++, linha++) {
					abrirQuadrado(linha, coluna);
				}
				linha--;
				coluna--;
				for (int counter = 0; counter < 2; counter++, coluna--) {
					abrirQuadrado(linha, coluna);
				}
				linha--;
				coluna++;
				for (int counter = 0; counter < 1; counter++, linha--) {
					abrirQuadrado(linha, coluna);
				}
				resultado = true;
			}
		}

		return resultado;
	}

	/**
	 * Marca um quadrado.
	 *
	 * @param linha Número da linha onde o quadrado está localizado no
	 * tabuleiro.
	 * @param coluna Número da coluna onde o quadrado está localizado no
	 * tabuleiro.
	 */
	private void marcarQuadrado(int linha, int coluna) {
		//marcar o quadrado.
	}

	/**
	 * Exibe o tabuleiro.
	 *
	 * @see model.Exibivel#exibir()
	 */
	@Override
	public void exibir() {
		//exibe quadrado por quadrado, até terminar a linha e depois quebra ela.
		//executa isso até terminar de imprimir toda a matriz.
	}
}
