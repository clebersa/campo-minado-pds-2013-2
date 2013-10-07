package model;

public class Conteudo {

	/**
	 * Representação de um conteúdo. Os possíveis valores que esta variável pode
	 * assumir são:<br/>
	 * '<tt>M</tt>' - Ícone que representa a presença de uma mina.<br/>
	 * '<tt>&nbsp;</tt>' - Ícone que representa um conteúdo vazio.<br/>
	 * '<tt>1</tt>' ... '<tt>8</tt>' - Ícone que representa a quantidade de
	 * minas vizinhas.
	 */
	private String icone;
	/**
	 * Tipo do conteúdo.
	 *
	 * @see model.TipoTabuleiro
	 */
	private TipoConteudo tipoConteudo;

	/**
	 * Cria um novo conteúdo.
	 * Na criação, o conteúdo é criado com o ícone <tt>'&nbsp;'</tt> e conteúdo
	 * <tt>TipoConteudo.VAZIO</tt>.
	 */
	public void Conteudo() {
		setTipo(TipoConteudo.VAZIO);
		setIcone(0);
	}

	/**
	 * Obtém o ícone do conteúdo.
	 *
	 * @return Ícone do conteúdo.
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * Define o ícone do conteúdo.
	 *
	 * @param minasVizinhas A quantidade de minas presentes na vizinhança do
	 * quadrado.<br/>
	 * Quando <tt>minasVizinhas &lt; 0</tt>, o tipo do conteúdo será definido
	 * para <tt>TipoConteudo.MINA</tt> e o ícone para '<tt>M</tt>'.<br/>
	 * Quando <tt>minasVizinhas = 0</tt>, o tipo do conteúdo será definido para
	 * <tt>TipoConteudo.VAZIO</tt> e o ícone para '<tt>&nbsp;</tt>'.<br/>
	 * Quando <tt>minasVizinhas &gt 0</tt>, o tipo do conteúdo será definido
	 * para <tt>TipoConteudo.NUMERO</tt> e o ícone para um número representando
	 * a quantidade de minas, que pode ir de <tt>1</tt> a <tt>8</tt>.
	 */
	public void setIcone(int minasVizinhas) {
		if (minasVizinhas < 0) {
			setTipo(TipoConteudo.MINA);
			icone = "M";
		} else if (minasVizinhas == 0 && getTipo() != TipoConteudo.MINA) {
			setTipo(TipoConteudo.VAZIO);
			icone = " ";
		} else if (getTipo() != TipoConteudo.MINA) {
			setTipo(TipoConteudo.NUMERO);
			icone = String.format("%d", minasVizinhas);
		}
	}

	/**
	 * Obtém o tipo do conteúdo.
	 *
	 * @return Tipo do conteúdo.
	 * @see model.TipoConteudo
	 */
	public TipoConteudo getTipo() {
		return tipoConteudo;
	}

	/**
	 * Define o tipo da mina.
	 *
	 * @see model.TipoConteudo
	 */
	private void setTipo(TipoConteudo tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}

	/**
	 * Adiciona uma mina ao conteúdo, mudando assim, seu tipo e ícone.
	 */
	public void adicionarMina() {
		setIcone(-1);
	}
}
