package br.com.reamp.dev;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import org.apache.http.client.ClientProtocolException;




	public class ClimaMain {
		
		
	    
		public static void  main(String args []) throws ClientProtocolException, IOException {
			
			int opc = 0;
			do{
			String cidade;
			Scanner scanner = new Scanner(System.in);
		    System.out.println("|   BEM VINDO A CENTRAL DO TEMPO     |");
		    System.out.println("| para continuar, informe o seu nome:|");
		    String nome = scanner.nextLine();
		    System.out.println(" 		Olá, "+ nome +"       ");
		    System.out.println(" O que deseja consultar:              ");
		    System.out.println("| 1- Previsão do tempo na sua cidade:|");
		    System.out.println("| 2- horário Local:                  |");
		    System.out.println("| 3- Sair                          	 |");
		  		    
		    opc = scanner.nextInt();

			 // Switch construct
		    switch (opc) {
		    
		    case 1:
		      System.out.println("Bem Vindos a previsão do tempo.");
		      System.out.println("Digite a cidade para previsão: ");
		      String cidade1 = scanner.next();
		      if(cidade1 != "") {
		      ClimaClient previsao = new ClimaClient();
		      previsao.service(cidade1);
		      String opc3 = scanner.next();
		
		      }else {
		    	  System.out.println("Desculpe não encontramos sua solicitação. Até logo!!");
		    	  clearConsole();
		      }
		      System.out.println("Obrigado por Usar");
		      break;
		    
		    case 2:
		    	
		      System.out.println("Horário de Brasilia");
		      LocalTime horaAgora = LocalTime.now();
		      System.out.println(horaAgora);
		      System.out.println("Obrigado por Usar");
		      break;
		      
		    case 3:
		      System.out.println("Quer mesmo sair?");
		      break;
		      
		   	default:
		     System.out.println("Selecão Inválida");
		     break; // This break is not really necessary
		    }
		    
		}while(opc == 3);
			 
	   }
		
		public final static void clearConsole(){

	        try{
	            final String os = System.getProperty("os.name");

	            if (os.contains("Windows")){
	                Runtime.getRuntime().exec("cls");

	            }else{
	                Runtime.getRuntime().exec("clear");
	            }
	        }
	        catch (final Exception e){
	        //  Tratar Exceptions
	        }
	    }
		
		
			
			
}
		  
		  
		  
		  
		 
		  
		  
		  
		  
		  
	
	

