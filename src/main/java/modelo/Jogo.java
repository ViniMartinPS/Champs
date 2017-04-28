package modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Jogo {

	private int idJogo;
	private String lugar;
	private Calendar horario;
	private int status;
	private int fase;
	private int grupo;
	
	private Equipe equipe1;
	private Equipe equipe2;
	private ArrayList<Placar> placares;
	public int getIdJogo() {
		return idJogo;
	}
	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Calendar getHorario() {
		return horario;
	}
	public void setHorario(Calendar horario) {
		this.horario = horario;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getFase() {
		return fase;
	}
	public void setFase(int fase) {
		this.fase = fase;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public Equipe getEquipe1() {
		return equipe1;
	}
	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}
	public Equipe getEquipe2() {
		return equipe2;
	}
	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}
	public ArrayList<Placar> getPlacares() {
		return placares;
	}
	public void setPlacares(ArrayList<Placar> placares) {
		this.placares = placares;
	}
	
	
	
	
}
