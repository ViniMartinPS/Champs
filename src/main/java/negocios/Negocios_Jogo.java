package negocios;

import java.util.ArrayList;

import dao.DAO_Jogo;
import modelo.Jogo;

public class Negocios_Jogo {

	private DAO_Jogo dao = new DAO_Jogo();
	
	public String updateJogo(Jogo jogo) {
		dao.updateJogo(jogo);
		dao.updatePlacar(jogo.getPlacares());
		return "";
	}
	
	public ArrayList<Jogo> getJogos(int idCampeonato){
		return dao.getJogos(idCampeonato);
	}

}
