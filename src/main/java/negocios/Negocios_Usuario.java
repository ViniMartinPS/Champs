package negocios;

import dao.DAO_Usuario;
import modelo.Login;
import modelo.Usuario;

public class Negocios_Usuario {

	private DAO_Usuario dao = new DAO_Usuario();
	
	public String logar(Login login){
		if( dao.logar(login)) return "Login Efetuado";
		else return "Login Falho";
	}
	
	public int cadastrarUsuario(Usuario usuario){
		int idUsuario = dao.cadastraUsuario(usuario);
		if (idUsuario != 0){
		Login login = new Login();
		login.setLogin(usuario.getEmail());
		login.setSenha(usuario.getSenha());
		return dao.cadastraLogin(login);
		}
		return 0;
	}
	
	public String esqueceuSenha(String email){
		if (dao.verificaEmail(email)){
			return enviaEmail(email);
		}
		else {
			return "Email Não Existe";
		}
	}
	
	public String enviaEmail(String email){
		return "";
	}
	
}
