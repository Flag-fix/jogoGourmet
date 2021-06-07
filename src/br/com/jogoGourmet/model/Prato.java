package br.com.jogoGourmet.model;

public class Prato {
	
	private String nomePrato;
	private Prato sim;
	private Prato nao;
	
	
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public Prato getSim() {
		return sim;
	}
	public void setSim(Prato sim) {
		this.sim = sim;
	}
	public Prato getNao() {
		return nao;
	}
	public void setNao(Prato nao) {
		this.nao = nao;
	}
	
	
}
