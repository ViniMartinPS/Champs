package resources;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.oxm.MediaType;

import modelo.Campeonato;
import modelo.Usuario;
import negocios.Negocios_Campeonato;


@Path("campeonato")
public class Resources_Campeonato {

	private Negocios_Campeonato negocios = new Negocios_Campeonato();

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, ArrayList<Campeonato>> getCampeonatos(Usuario usuario){
		return negocios.getCampeonatos(usuario);
	}
	
	@GET
	@Path("/{idCampeonato}")
	@Produces(MediaType.APPLICATION_JSON)
	public Campeonato getCampeonato(@PathParam("idCampeonato") int idCampeonato){
		return negocios.getCampeonato(idCampeonato);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int createCampeonatos(Campeonato campeonato){
		return negocios.createCampeonatos(campeonato);
	}
	
	@POST
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public String atualizaCampeonato(Campeonato campeonato){
		return negocios.atualizaCampeonato(campeonato);
	}
	
	@POST
	@Path("/gerarProximaFase/{idCampeonato}")
	@Produces(MediaType.APPLICATION_JSON)
	public Campeonato gerarProximaFase(@PathParam("idCampeonato") int idCampeonato){
		return negocios.gerarProximaFase(idCampeonato);
	}
	
	@GET
	@Path("/pesquisar/{stringPesquisa}")
	public Object buscaCampeonatos(@PathParam("stringPesquisa") String stringPesquisa) {
		return negocios.buscaCampeonatos(stringPesquisa);
	}
	
}
