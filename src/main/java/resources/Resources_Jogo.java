package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import org.eclipse.persistence.oxm.MediaType;

import modelo.Jogo;
import negocios.Negocios_Jogo;

public class Resources_Jogo {

	Negocios_Jogo negocios = new Negocios_Jogo();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateJogo(Jogo jogo){
		return negocios.updateJogo(jogo);
	}
	
	
	
}
