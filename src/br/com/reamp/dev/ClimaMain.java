package br.com.reamp.dev;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import org.apache.http.client.ClientProtocolException;




	public class ClimaMain {
		
		
	    
		public static void  main(String args []) throws ClientProtocolException, IOException {
			
			int opc = 0;
			Scanner scanner = new Scanner(System.in);
		    System.out.println("| ** BEM VINDO A CENTRAL DO TEMPO  **  |");
		    System.out.println("Para continuar, informe o seu nome: ...");
		    	    
		    String nome = scanner.nextLine();
		    System.out.println("	Olá, "+ nome +"       ");
		    System.out.println(" O que deseja consultar:              ");
		    System.out.println("| 1- Previsão do tempo na sua cidade:|");
		    System.out.println("| 2- horário Local:                  |");
		    System.out.println("| 3- Sair                       	 |");
		  		    
		    opc = scanner.nextInt();

			 // Switch construct
		    switch (opc) {
		    
		    case 1:
		    	
		      System.out.println("**Bem Vindo a previsão do tempo.**");
		      System.out.println("Digite a cidade para previsão: ");
		      Scanner scan = new Scanner(System.in);
		      String cidade = scan.nextLine();
		      ClimaClient previsao = new ClimaClient();
		      previsao.service(cidade);
		      System.out.println("Obrigado por Usar");
		      
		      break;
		    
		    case 2:
		    	
		      System.out.println("Horário de Brasilia");
		      LocalTime horaAgora = LocalTime.now();
		      System.out.println(horaAgora);
		      System.out.println("Obrigado por Usar");
		      break;
		      
		    case 3:
		      System.out.println("Até Logo");
		      break;
		      
		   	default:
		     System.out.println("Selecão Inválida");
		     break; 
		    }
		    
		
			 
	   }
		
			
}
		  
		  
		  
		  
		 
		  
		  
		  
		  
		  
	
	

