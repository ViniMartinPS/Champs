package negocios;

import java.util.ArrayList;
import java.util.HashMap;

import dao.DAO_Campeonato;
import dao.DAO_Jogo;
import dao.DAO_Usuario;
import modelo.Campeonato;
import modelo.CampeonatoGrupo;
import modelo.CampeonatoLiga;
import modelo.CampeonatoMataMata;
import modelo.Classificacao;
import modelo.Desempate;
import modelo.Jogo;
import modelo.Usuario;

public class Negocios_Campeonato {

	private DAO_Campeonato dao = new DAO_Campeonato();
	
	public HashMap<String, ArrayList<Campeonato>> getCampeonatos(Usuario usuario) {
		HashMap<String, ArrayList<Campeonato>> hashCampeonatos = new HashMap<String, ArrayList<Campeonato>>();
		ArrayList<Campeonato> meusCampeonatos = dao.getMeusCampeonatos(usuario);
		ArrayList<Campeonato> meusFavoritos = dao.getMeusFavoritos(usuario);
		
		hashCampeonatos.put("meusCampeonatos", meusCampeonatos);
		hashCampeonatos.put("meusFavoritos", meusFavoritos);
		
		return hashCampeonatos;
		
	}

	public Campeonato getCampeonato(int idCampeonato) {
		
		Campeonato campeonato = new Campeonato();
		campeonato = dao.getCampeonato(idCampeonato);
		
		ArrayList<Classificacao> listaClassificacoes = dao.getClassificacoes(idCampeonato);
		campeonato.setClassificacoes(listaClassificacoes);
		
		ArrayList<Desempate> desempates = dao.getDesempate(idCampeonato);
		campeonato.setDesempates(desempates);
		
		DAO_Jogo daoJogo = new DAO_Jogo();
		ArrayList<Jogo> jogos = daoJogo.getJogos(idCampeonato);
		campeonato.setJogos(jogos);
		
		DAO_Usuario daoUsuario = new DAO_Usuario();
		ArrayList<Usuario> admins = daoUsuario.getAdmins(idCampeonato);
		campeonato.setAdmins(admins);
		
		if (campeonato.getTipo().equals("liga")){
			CampeonatoLiga campLiga = new CampeonatoLiga();
			campLiga= dao.getCampeonatoLiga(idCampeonato);
			campeonato.setCampeonatoLiga(campLiga);
		} else if (campeonato.getTipo().equals("matamata")){
			CampeonatoMataMata campMataMata = new CampeonatoMataMata();
			campMataMata = dao.getCampeonatoMataMata(idCampeonato);
			campeonato.setCampeonatoMataMata(campMataMata);
		} else if (campeonato.getTipo().equals("grupo")){
			CampeonatoGrupo campGrupo = new CampeonatoGrupo();
			campGrupo = dao.getCampeonatoGrupo(idCampeonato);
			campeonato.setCampeonatoGrupo(campGrupo);
		}
		
		return campeonato;
	}

	public int createCampeonatos(Campeonato campeonato) {
		return dao.createCampeonato(campeonato);
	}

	public String atualizaCampeonato(Campeonato campeonato) {
		return dao.atualizaCampeonato(campeonato);
	}

	public Object buscaCampeonatos(String stringPesquisa) {
		String[] splitString = stringPesquisa.split("_._");
		
		
		if (splitString[0].equals("buscaId")){
			return dao.buscaCampeonatos(Integer.parseInt(splitString[1]));
		}else if (splitString[0].equals("buscaNome")){
			return dao.buscaCampeonatos(splitString[1]);
		} else return null;
	}
	
	

}
