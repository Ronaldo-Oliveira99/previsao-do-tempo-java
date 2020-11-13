package br.com.reamp.dev;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
		  String CITY =  cidadeBusca;
		  String API_KEY = "c3b26095ada747bb0596244a3d87af89";
		  ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  
			  WebResource service = client.resource(UriBuilder.fromUri(URL+"?q="+CITY +"&appid=" + API_KEY).build());
			  String services = service.accept(MediaType.APPLICATION_JSON).get(String.class);
			  JSONObject myResponse = new JSONObject(services);
			  
			  //OBTENDO OBJETOS
			  JSONArray arrLista = myResponse.getJSONArray("list");
			  JSONObject cityInfo = myResponse.getJSONObject("city");
			  
			  String cidade = cityInfo.getString("name");
			  String country = cityInfo.getString("country");
			  System.out.println("------------------------------------"); 
			  System.out.println("Cidade: " +cidade); 
			  System.out.println("Páis: " +country);
			  System.out.println("--Previsão para a próximos dias: --");
			  System.out.println();
		
		  
		  for (int i=0; i < 8; i++) {

				//RECUPERA PREVISÕES/DIA
				JSONObject f = arrLista.getJSONObject(i);
				
				int datas = f.getInt("dt");	
				
				//FORMATA DATAS
			
				Calendar dt = Calendar.getInstance();
				dt.setTime( new Date());
				dt.add(Calendar.DAY_OF_MONTH, i);	
				Date data = dt.getTime();
				
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy"); 
				String formattedDate = sdf.format(data);
				
				System.out.println("Data: " + formattedDate);
		
					
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
				System.out.println("Máxima: " + maxima/10+"°");
			
				int temperatura = mains.getInt("temp");
				System.out.println("Temperatura : " +temperatura/12+"°");
				
				System.out.println("Humidade do Ar: " + mains.getInt("humidity")+"%");
				int humidade = mains.getInt("temp");
				
				System.out.println("-----------------------");
		
		  }
		  
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}

	}
	
	public ClimaClient() {
	
	}

}
