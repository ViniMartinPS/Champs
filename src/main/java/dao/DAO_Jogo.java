package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Jogo;

public class DAO_Jogo {

	public String updateJogo(Jogo jogo) {
		String sqlUpdate;
		Connection conn = null;
		PreparedStatement stm = null;
						
		try {
			ConexaoBD bd = new ConexaoBD();
			conn = bd.obtemConexao();
			sqlUpdate = "UPDATE jogo set lugar = ? and horario = ? and fase = ? and status = ? where idJogo = ?;";

			stm = conn.prepareStatement(sqlUpdate);
			stm.setString(1, jogo.getLugar());
			stm.setCalendar(2, jogo.getHorario());
			stm.setInt(3,  jogo.getFase());
			stm.setInt(4,  jogo.getStatus());
			stm.setInt(5,  jogo.getIdJogo());


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
		return "Jogo Atualizado";
	}

}
