package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import modelo.Login;
import modelo.Usuario;
import negocios.Negocios_Usuario;

@Path("usuario")
public class Resources_Usuario {

	private Negocios_Usuario negocios = new Negocios_Usuario();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int cadastrarUsuario(Usuario usuario){ 
		return negocios.cadastrarUsuario(usuario);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String logar(Login login){
		return negocios.logar(login);
	}
	
	@POST
	@PathParam("/esqueceuSenha/{email}")
	public String esqueceuSenha(@PathParam("email") String email){
		return negocios.esqueceuSenha(email);
	}
	
}
