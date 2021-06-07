package br.com.jogoGourmet.controller;

import br.com.jogoGourmet.model.Prato;
import br.com.jogoGourmet.view.Principal;

public class GourmetGameController {

	private Prato start;
	private final int SIM = 0;
	private final int NAO = 1;

	public GourmetGameController() {
		start = object();
	}

	public Prato object() {

		Prato lasanha = new Prato();
		lasanha.setNomePrato("Lasanha");
		lasanha.setSim(null);
		lasanha.setNao(null);

		Prato bolo = new Prato();
		bolo.setNomePrato("Bolo de Chocolate");
		bolo.setSim(null);
		bolo.setNao(null);

		Prato tipo = new Prato();
		tipo.setNomePrato("Massa");
		tipo.setSim(lasanha);
		tipo.setNao(bolo);

		return tipo;
	}

	public void startActivity() {
		next(start);
	}

	public Prato next(Prato current) {
		int choice = Principal.showPerguntaPrato(current.getNomePrato());
		Prato nomeNovoPrato;
		switch (choice) {
		case SIM:
			if (current.getSim() == null) {
				Principal.showAcertei();
				nomeNovoPrato = null;
			} else {
				nomeNovoPrato = next(current.getSim());
				if (nomeNovoPrato != null) {
					current.setSim(nomeNovoPrato);
					nomeNovoPrato = null;
				}
			}
			break;

		case NAO:
			if (current.getNao() == null) {
				nomeNovoPrato = criarNovoPrato(current);
			} else {
				nomeNovoPrato = next(current.getNao());
				if (nomeNovoPrato != null) {
					current.setNao(nomeNovoPrato);
					nomeNovoPrato = null;
				}
			}
			break;
		default:
			nomeNovoPrato = null;
			break;
		}
		return nomeNovoPrato;
	}
	
	
	public Prato criarNovoPrato(Prato current) {
		String novoPrato = Principal.showPerguntaNovoPrato();
		
		if(novoPrato != null){
			novoPrato =  novoPrato.trim();
			if(!novoPrato.equals("")){
				Prato novo = new Prato();
				novo.setNomePrato(novoPrato);
				novo.setSim(null);
				novo.setNao(null);
				
				String difNovoAtualPrato = Principal.showPerguntaDiferenca(novoPrato, current.getNomePrato());
				
				Prato pratoDiferente = new Prato();
				pratoDiferente.setNomePrato(difNovoAtualPrato);
				pratoDiferente.setSim(novo);
				pratoDiferente.setNao(current);
				
				return pratoDiferente;
				
			}
		}
		
		return null;
	}

}
