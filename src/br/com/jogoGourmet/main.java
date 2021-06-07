package br.com.jogoGourmet;

import javax.swing.JFrame;
import br.com.jogoGourmet.controller.GourmetGameController;
import br.com.jogoGourmet.view.Principal;

public class main {
	
	public static void main(String[] args) {
		GourmetGameController controller = new GourmetGameController();
		JFrame main = Principal.getFramePrincipal(controller);
		main.setVisible(true);
	}
}
