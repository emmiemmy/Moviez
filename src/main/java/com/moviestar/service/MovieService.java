package com.moviestar.service;

import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.moviestar.entity.Movie;
import com.moviestar.util.ToJSON;

@Path("/collection")
public class MovieService {
	
	@Path("/bestmovie")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovie(){
		Response rs = null;
		
		
		Movie movieObject = new Movie();
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		ToJSON converter = new ToJSON();
		Map<String, Object> map;
		
		//Skapa ett objekt
		movieObject.setActor("Kiera Knightley");
		movieObject.setTitle("Pirates of the carribean");
		movieObject.setDirector("Who knows");
		movieObject.setPlot("Johnny Depp takes on the world again");
		map = movieObject.getMap();
		
		jo = converter.toJSONArray(map);
		ja.put(jo);
		
		movieObject.setActor("Billy Boo");
		movieObject.setTitle("And on he take sit again");
		movieObject.setDirector("Willy Weiner");
		movieObject.setPlot("Three en are stuck in the dessert....");
		map = movieObject.getMap();
		
		jo = converter.toJSONArray(map);
		ja.put(jo);
		
		rs = Response.ok(ja.toString()).build();
		
		return rs;
	}

}
	


