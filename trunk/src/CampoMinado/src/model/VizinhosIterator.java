package model;

import java.util.Iterator;

public class VizinhosIterator implements Iterator<Quadrado> {

	private Quadrado quadrados[][];
	private int linha;
	private int coluna;
	private int linhaQuadrado;
	private int colunaQuadrado;

	public void VizinhosIterator(Quadrado quadrados[][], int linhaQuadrado, int colunaQuadrado) {
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Quadrado next() {
		return null;
	}

	@Override
	public void remove() {
	}
}
