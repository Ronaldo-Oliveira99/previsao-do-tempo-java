package br.com.reamp.dev;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;



public class ClimaClient {

	

	public void service(String cidadeBusca){
		
		try {
			
		  String URL = "http://api.openweathermap.org/data/2.5/forecast";
		  String CITY =  cidadeBusca.replace(" ", "%20");
		  String API_KEY = "c3b26095ada747bb0596244a3d87af89";
		  ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  
			  WebResource service = client.resource(UriBuilder.fromUri(URL+"?q="+CITY+"&lang=pt_br&appid=" + API_KEY+"&").build());
			  String services = service.accept(MediaType.APPLICATION_JSON).get(String.class);
			  JSONObject myResponse = new JSONObject(services);
			  
			  //OBTENDO OBJETOS
			  JSONArray arrLista = myResponse.getJSONArray("list");
			  JSONObject cityInfo = myResponse.getJSONObject("city");
			  
			  String cidade = cityInfo.getString("name");
			  String country = cityInfo.getString("country");
			  System.out.println("------------------------------------"); 
			  System.out.println("Cidade: " +cidade); 
			  System.out.println("Pais: " +country);
			  System.out.println("--Próximas previsões para esta cidade: --");
			  System.out.println();
		
			 
		  for (int i=0; i < arrLista.length(); i++) {

				//RECUPERA PREVISÕES/DIA
				JSONObject f = arrLista.getJSONObject(i);
				
				 Object datas = f.get("dt_txt");	
				
				
				System.out.println("Data: " + datas);
		
					
				//RECUPERA COLEÇÕES
				JSONObject mains = f.getJSONObject("main");
				JSONArray weather = f.getJSONArray("weather");
				
				
				//ITERAR POR WEATHER
				for (int k=0; k < 1; k++) {
					JSONObject y = weather.getJSONObject(k);
					String main = y.getString("main");
					String description = y.getString("description");
					String icon = y.getString("icon");
					
					System.out.println("Tempo: " + main);
			
					System.out.println("Detalhes: " + description);
			
					System.out.println("icon: " + icon);
				}
				
				int minima = mains.getInt("temp_min");
				System.out.println("Mínima: " +minima/18+"°");
				
				int maxima = mains.getInt("temp_max");
				System.out.println("Máxima: " + maxima/11+"°");
			
				int temperatura = mains.getInt("temp");
				System.out.println("Temperatura : " +temperatura/14+"°");
				
				System.out.println("Humidade do Ar: " + mains.getInt("humidity")+"%");
				int humidade = mains.getInt("temp");
				
				System.out.println("-----------------------");
		
		  }
		  
		} catch (Exception e) {
			System.out.println("Não encontrado, tente novamente!");
			System.out.println(e.getCause());
			
		}

	}
	
	public ClimaClient() {
	
	}

}
