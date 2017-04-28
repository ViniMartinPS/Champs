package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Campeonato {

	private int idCampeonato;
	private String nome;
	private String tipo;
	private int quantidadeParticipantes;
	private Date dataCriacao;
	private int faseAtual;
	private int idUsuarioCriador;
	
	private ArrayList<Equipe> equipes;
	private ArrayList<Classificacao> classificacoes;
	private ArrayList<Desempate> desempates;
	private ArrayList<Jogo> jogos;
	private ArrayList<Usuario> admins;
	
	private CampeonatoGrupo campeonatoGrupo;
	private CampeonatoLiga campeonatoLiga;
	private CampeonatoMataMata campeonatoMataMata;	
	
	public CampeonatoGrupo getCampeonatoGrupo() {
		return campeonatoGrupo;
	}
	public void setCampeonatoGrupo(CampeonatoGrupo campeonatoGrupo) {
		this.campeonatoGrupo = campeonatoGrupo;
	}
	public CampeonatoLiga getCampeonatoLiga() {
		return campeonatoLiga;
	}
	public void setCampeonatoLiga(CampeonatoLiga campeonatoLiga) {
		this.campeonatoLiga = campeonatoLiga;
	}
	public CampeonatoMataMata getCampeonatoMataMata() {
		return campeonatoMataMata;
	}
	public void setCampeonatoMataMata(CampeonatoMataMata campeonatoMataMata) {
		this.campeonatoMataMata = campeonatoMataMata;
	}
	public int getIdCampeonato() {
		return idCampeonato;
	}
	public void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getQuantidadeParticipantes() {
		return quantidadeParticipantes;
	}
	public void setQuantidadeParticipantes(int quantidadeParticipantes) {
		this.quantidadeParticipantes = quantidadeParticipantes;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public int getFaseAtual() {
		return faseAtual;
	}
	public void setFaseAtual(int faseAtual) {
		this.faseAtual = faseAtual;
	}
	public int getIdUsuarioCriador() {
		return idUsuarioCriador;
	}
	public void setIdUsuarioCriador(int idUsuarioCriador) {
		this.idUsuarioCriador = idUsuarioCriador;
	}
	public ArrayList<Classificacao> getClassificacoes() {
		return classificacoes;
	}
	public void setClassificacoes(ArrayList<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}
	public ArrayList<Desempate> getDesempates() {
		return desempates;
	}
	public void setDesempates(ArrayList<Desempate> desempates) {
		this.desempates = desempates;
	}
	public ArrayList<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}
	public ArrayList<Usuario> getAdmins() {
		return admins;
	}
	public void setAdmins(ArrayList<Usuario> admins) {
		this.admins = admins;
	}
	
	
	
}
