package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Classificacao;
import modelo.Equipe;
import modelo.Login;
import modelo.Usuario;

public class DAO_Usuario {

	public boolean logar(Login login){
					
			String sqlSelect;
			Connection conn = null;
			Statement stm = null;
			
			String senha="";
			
			try {
				ConexaoBD bd = new ConexaoBD();
				conn = bd.obtemConexao();
				sqlSelect = "SELECT senha FROM login where email = \"" + login.getLogin() + "\";";
				stm = conn.createStatement();
				java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
				while(rs.next()){
						senha = rs.getString("senha");
					}
			} catch (Exception e) {
				return false;
			}finally{
				if (stm != null) {
					try {
						stm.close();
					} catch (SQLException e) {
						return false;
					}
				}
				// fecha a conexao
				//
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						return false;
					}
				}
			}
			if (login.getSenha().equals(senha)){
				return true;
				}
			else return false;
	}

	public int cadastraUsuario(Usuario usuario){
		String sqlUpdate;
		Connection conn = null;
		PreparedStatement stm = null;
				
		int idUsuario =0;
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlUpdate = "INSERT INTO usuario values (?,?,?,?)";

			stm = conn.prepareStatement(sqlUpdate);
			stm.setString(1, usuario.getEmail());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getSexo());
			stm.setDate(4, (Date) usuario.getDob());

			idUsuario = stm.executeUpdate();
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
		return idUsuario;
	}

	public int cadastraLogin(Login login){
		String sqlUpdate;
		Connection conn = null;
		PreparedStatement stm = null;
				
		int idUsuario =0;
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlUpdate = "INSERT INTO login values (?,?)";

			stm = conn.prepareStatement(sqlUpdate);
			stm.setString(1, login.getLogin());
			stm.setString(2, login.getSenha());


			idUsuario = stm.executeUpdate();
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
		return idUsuario;
	}
	
	public boolean verificaEmail(String email){
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
				
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT email FROM login where email = \"" + email + "\";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				return true;
				}
		} catch (Exception e) {
			return false;
		}finally{
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					return false;
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					return false;
				}
			}
		}
		return false;
	}

	public ArrayList<Usuario> getAdmins(int idCampeonato) {
		String sqlSelect;
		Connection conn = null;
		Statement stm = null;
		
		ArrayList<Usuario> listaAdmins = new ArrayList<Usuario>();
		
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlSelect = "SELECT * from campeonato_admin where idCampeonato =  " + idCampeonato + ";";
			stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sqlSelect);
			while(rs.next()){
				
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
									
					listaAdmins.add(usuario);
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
		return listaAdmins;
	}
	
}
