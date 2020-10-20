import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.OutputStream; 
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket; 
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class verificador {
  public static void main(String[] args) {

	  
	    Socket client;
        DataOutputStream dos;
        InetAddress jorgeyjosue;
		JSONParser parser = new JSONParser();
		
		 String path = "verificador";


         String[] files = getFiles( path );

         if ( files != null ) {

             int size = files.length;

             for ( int i = 0; i < size; i ++ ) {

                 System.out.println( files[ i ] );
		

		try {

			    
			Object obj = parser.parse(new FileReader(files[i]));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			
			String agente = (String) jsonObject.get("agente");
			System.out.println("Agente: "+agente);
			
			String fechahoraUTC = (String) jsonObject.get("fechahoraUTC");
			System.out.println("Fecha: "+fechahoraUTC);

		
			
			
			JSONArray lista = (JSONArray) jsonObject.get("lecturas");
			Iterator<JSONObject> iterator = lista.iterator();
		
			  
			
			while (iterator.hasNext()) {
				
				JSONObject salto = (JSONObject) iterator.next();
				String sensor = (String) salto.get("sensor");
				System.out.println("sensor: "+sensor);
				
				double dato = 0.0;
				if(salto.get("lectura") instanceof Number) {
					
				dato = ((Number) salto.get("lectura")).doubleValue();
				System.out.println("lectura: "+dato);
				
				
				}
				else {
					return;
				}
				
			}
			
			jorgeyjosue = InetAddress.getByName("10.10.10.1");
		    client = new Socket(jorgeyjosue, 9999);
		    dos = new DataOutputStream(client.getOutputStream());
	       
	        dos.writeUTF(agente);
	        dos.writeUTF(fechahoraUTC);
	        

	        client.close();
			

		} catch (FileNotFoundException e) {
			//manejo de error
		} catch (IOException e) {
			//manejo de error
		} catch (ParseException e) {
			//manejo de error
		}
		
		catch (Throwable t){
	        t.printStackTrace();
	      }

	}
         }
  }


  public static String[] getFiles( String obj ) {

      String[] arr_res = null;

      File f = new File( obj );

      if ( f.isDirectory( )) {

          List<String> res   = new ArrayList<>();
          File[] arr_content = f.listFiles();

          int size = arr_content.length;

          for ( int i = 0; i < size; i ++ ) {

              if ( arr_content[ i ].isFile( ))
              res.add( arr_content[ i ].toString( ));
          }


          arr_res = res.toArray( new String[ 0 ] );

      } else
          System.err.println( "¡ Path NO válido !" );


      return arr_res;
  }

}
