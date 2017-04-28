package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Campeonato;
import modelo.CampeonatoGrupo;
import modelo.CampeonatoLiga;
import modelo.CampeonatoMataMata;
import modelo.Classificacao;
import modelo.Desempate;
import modelo.Equipe;
import modelo.Usuario;

public class DAO_Campeonato {

	public ArrayList<Campeonato> getMeusCampeonatos(Usuario usuario) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		
		ArrayList<Campeonato> listaCampeonatos = new ArrayList<Campeonato>();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato INNER JOIN usuario_campeonato ON campeonato.idCampeonato = usuario_campeonato.idCampeonato and usuario_campeonato.idUsuario =  " + usuario.getIdUsuario() + "and usuario_campeonato.relacao =  " + 1 +";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				Campeonato campeonato = new Campeonato();
					campeonato.setIdCampeonato(rs.getInt("idCampeonato"));
					campeonato.setNome(rs.getString("nome"));
					campeonato.setTipo(rs.getString("tipo"));
					campeonato.setQuantidadeParticipantes(rs.getInt("quantidadeParticipantes"));
					campeonato.setDataCriacao(rs.getDate("dataCriacao"));
					campeonato.setFaseAtual(rs.getInt("faseAtual"));
					campeonato.setIdUsuarioCriador(rs.getInt("idUsuarioCriador"));
					
					listaCampeonatos.add(campeonato);
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return listaCampeonatos;
	}

	public ArrayList<Campeonato> getMeusFavoritos(Usuario usuario) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		
		ArrayList<Campeonato> listaCampeonatos = new ArrayList<Campeonato>();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato INNER JOIN usuario_campeonato ON campeonato.idCampeonato = usuario_campeonato.idCampeonato and usuario_campeonato.idUsuario =  " + usuario.getIdUsuario() + "and usuario_campeonato.relacao =  " + 2 +";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				Campeonato campeonato = new Campeonato();
					campeonato.setIdCampeonato(rs.getInt("idCampeonato"));
					campeonato.setNome(rs.getString("nome"));
					campeonato.setTipo(rs.getString("tipo"));
					campeonato.setQuantidadeParticipantes(rs.getInt("quantidadeParticipantes"));
					campeonato.setDataCriacao(rs.getDate("dataCriacao"));
					campeonato.setFaseAtual(rs.getInt("faseAtual"));
					campeonato.setIdUsuarioCriador(rs.getInt("idUsuarioCriador"));
					
					listaCampeonatos.add(campeonato);
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return listaCampeonatos;
	}
	
	public Campeonato getCampeonato(int idCampeonato) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
				
		Campeonato campeonato = new Campeonato();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato idCampeonato = " + idCampeonato +";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				
					campeonato.setIdCampeonato(rs.getInt("idCampeonato"));
					campeonato.setNome(rs.getString("nome"));
					campeonato.setTipo(rs.getString("tipo"));
					campeonato.setQuantidadeParticipantes(rs.getInt("quantidadeParticipantes"));
					campeonato.setDataCriacao(rs.getDate("dataCriacao"));
					campeonato.setFaseAtual(rs.getInt("faseAtual"));
					campeonato.setIdUsuarioCriador(rs.getInt("idUsuarioCriador"));
					
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return campeonato;
	}
	
	public ArrayList<Desempate> getDesempate(int idCampeonato){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		
		ArrayList<Desempate> listaDesempate = new ArrayList<Desempate>();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from desempate INNER JOIN campeonato_desempate ON desempate.idDesempate = campeonato_desempate.idDesempate and campeonato_desempate.idCampeonato =  " + idCampeonato + ";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				Desempate desempate = new Desempate();
					desempate.setIdDesempate(rs.getInt("idDesempate"));
					desempate.setNomeDesempate(rs.getShort("nomeDesempate"));
					desempate.setPrioridade(rs.getInt("prioridade"));
					
					listaDesempate.add(desempate);
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return listaDesempate;
	}
	
	public ArrayList<Classificacao> getClassificacoes(int idCampeonato){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		
		ArrayList<Classificacao> listaClassificacoes = new ArrayList<Classificacao>();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from classificacao inner join equipe on classificacao.idEquipe = equipe.idEquipe where idCampeonato =  " + idCampeonato + ";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				Classificacao classificacao = new Classificacao();
					classificacao.setIdClassificacao(rs.getInt("idClassificacao"));
					classificacao.setPosicao(rs.getInt("posicao"));
					classificacao.setProprios(rs.getInt("proprios"));
					classificacao.setContras(rs.getInt("contras"));
					classificacao.setSaldo(rs.getInt("saldo"));
					classificacao.setPropriosAux(rs.getInt("propriosAux"));
					classificacao.setContrasAux(rs.getInt("contrasAux"));
					classificacao.setSaldoAux(rs.getInt("saldoAux"));
					classificacao.setGrupo(rs.getInt("grupo"));
					classificacao.setVitorias(rs.getInt("vitorias"));
					classificacao.setDerrotas(rs.getInt("derrotas"));
					classificacao.setEmpates(rs.getInt("empates"));
					classificacao.setJogos(rs.getInt("jogos"));
					
					Equipe equipe = new Equipe();
					equipe.setIdEquipe(rs.getInt("idEquipe"));
					equipe.setNomeEquipe(rs.getString("nomeEquipe"));
					
					classificacao.setEquipe(equipe);
					
					listaClassificacoes.add(classificacao);
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return listaClassificacoes;
	}

	public CampeonatoLiga getCampeonatoLiga(int idCampeonato) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
				
		CampeonatoLiga campeonatoLiga = new CampeonatoLiga();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato_liga idCampeonato = " + idCampeonato +";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				
					campeonatoLiga.setIdCampeonato(rs.getInt("idCampeonato"));
					campeonatoLiga.setIdLiga(rs.getInt("idLiga"));
					campeonatoLiga.setQuantidadeTurnos(rs.getInt("quantidadeTurnos"));
					
					
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return campeonatoLiga;
	}
	
	public CampeonatoMataMata getCampeonatoMataMata(int idCampeonato) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
				
		CampeonatoMataMata campeonatoMataMata = new CampeonatoMataMata();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato_matamata idCampeonato = " + idCampeonato +";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				
				campeonatoMataMata.setIdCampeonato(rs.getInt("idCampeonato"));
				campeonatoMataMata.setIdMataMata(rs.getInt("idMataMata"));
				if (rs.getInt("flagIdaVolta") == 1) campeonatoMataMata.setFlagIdaVolta(true);
				else campeonatoMataMata.setFlagIdaVolta(false);
				if (rs.getInt("flagSorteioProximaFase") == 1) campeonatoMataMata.setFlagSorteioProximaFase(true);
				else campeonatoMataMata.setFlagSorteioProximaFase(false);
				if (rs.getInt("flagPropriosFora") == 1) campeonatoMataMata.setFlagPropriosFora(true);
				else campeonatoMataMata.setFlagPropriosFora(false);	
				
					
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return campeonatoMataMata;
	}
	
	public CampeonatoGrupo getCampeonatoGrupo(int idCampeonato) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
				
		CampeonatoGrupo campeonatoGrupo = new CampeonatoGrupo();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato_grupo idCampeonato = " + idCampeonato +";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				
				campeonatoGrupo.setIdCampeonato(rs.getInt("idCampeonato"));
				campeonatoGrupo.setIdGrupo(rs.getInt("idMataMata"));
				if (rs.getInt("flagIdaVolta") == 1) campeonatoGrupo.setFlagIdaVolta(true);
				else campeonatoGrupo.setFlagIdaVolta(false);
				if (rs.getInt("flagSorteioProximaFase") == 1) campeonatoGrupo.setFlagSorteioProximaFase(true);
				else campeonatoGrupo.setFlagSorteioProximaFase(false);
				if (rs.getInt("flagPropriosFora") == 1) campeonatoGrupo.setFlagPropriosFora(true);
				else campeonatoGrupo.setFlagPropriosFora(false);	
				campeonatoGrupo.setQuantidadeTurnos(rs.getInt("quantidadeTurnos"));
				campeonatoGrupo.setQuantidadeClassificados(rs.getInt("quantidadeClassificados"));
				campeonatoGrupo.setQuantidadeGrupos(rs.getInt("quantidadeGrupos"));
				
				
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return campeonatoGrupo;
	}
	
	public int createCampeonato(Campeonato campeonato){
		String sqlUpdate;
		Connection conn = null;
		PreparedStatement stm = null;
				
		int idCampeonato =0;
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlUpdate = "INSERT INTO campeonato values (?,?,?,?)";

			stm = conn.prepareStatement(sqlUpdate);
			stm.setString(1, campeonato.getNome());
			stm.setString(2, campeonato.getTipo());
			stm.setInt(3, campeonato.getQuantidadeParticipantes());
			stm.setDate(4, (Date) campeonato.getDataCriacao());
			stm.setInt(5, campeonato.getFaseAtual());
			stm.setInt(6, campeonato.getIdUsuarioCriador());

			idCampeonato = stm.executeUpdate();
			}catch (SQLException e){
				return 0;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return 0;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return 0;
				}
			}
		}
		return idCampeonato;
	}

	public String atualizaCampeonato(Campeonato campeonato) {
		String sqlUpdate;
		Connection conn = null;
		PreparedStatement stm = null;
						
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlUpdate = "UPDATE campeonato set nome = ? and faseAtual = ? where idCampeonato = ?;";

			stm = conn.prepareStatement(sqlUpdate);
			stm.setString(1, campeonato.getNome());
			stm.setInt(2, campeonato.getFaseAtual());
			stm.setInt(3,  campeonato.getIdCampeonato());

			stm.executeUpdate();
			}catch (SQLException e){
				return "Error";
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return "Error";
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return "Error";
				}
			}
			
		}
		return "Campeonaoto Atualizado";
	}

	public Campeonato buscaCampeonatos(int idCampeonato) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		
		Campeonato campeonato = new Campeonato();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato where idCampeonato = " + idCampeonato + ";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				
					campeonato.setIdCampeonato(rs.getInt("idCampeonato"));
					campeonato.setNome(rs.getString("nome"));
					campeonato.setTipo(rs.getString("tipo"));
					campeonato.setQuantidadeParticipantes(rs.getInt("quantidadeParticipantes"));
					campeonato.setDataCriacao(rs.getDate("dataCriacao"));
					campeonato.setFaseAtual(rs.getInt("faseAtual"));
					campeonato.setIdUsuarioCriador(rs.getInt("idUsuarioCriador"));
					
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return campeonato;
	}

	public Object buscaCampeonatos(String nomeCampeonato) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		
		ArrayList<Campeonato> listaCampeonatos = new ArrayList<Campeonato>();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato where nome LIKE \"%" + nomeCampeonato + "%\" ;";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				Campeonato campeonato = new Campeonato();
					campeonato.setIdCampeonato(rs.getInt("idCampeonato"));
					campeonato.setNome(rs.getString("nome"));
					campeonato.setTipo(rs.getString("tipo"));
					campeonato.setQuantidadeParticipantes(rs.getInt("quantidadeParticipantes"));
					campeonato.setDataCriacao(rs.getDate("dataCriacao"));
					campeonato.setFaseAtual(rs.getInt("faseAtual"));
					campeonato.setIdUsuarioCriador(rs.getInt("idUsuarioCriador"));
					
					listaCampeonatos.add(campeonato);
				}
		} catch (Exception e) {
			return null;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return null;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return listaCampeonatos;
	}
	
}
