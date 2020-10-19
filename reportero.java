import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket; 
import java.net.Socket; 
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class reportero {

	public static void main(String[] args) {

		JSONObject obj = new JSONObject();
		
		ServerSocket server;
	    Socket client;
	    InputStream is;
	    DataInputStream dis;
	    
	    String age;
	    String fecha;
	    
	       
	    
		JSONArray list = new JSONArray();
		 
		

		

		try  {
			
			server = new ServerSocket(9999);
			
	        for (int j = 10; (--j) >= 0;){
	        	
			    System.out.println("prueba");

	            client = server.accept();

	            dis = new DataInputStream(client.getInputStream());

			    age = dis.readUTF();
			    fecha = dis.readUTF();
			    
			    
			    dis.close();
			    client.close();
			    
			    
			    System.out.println(age);
			    System.out.println(fecha);
			   

			    

		        FileWriter file = new FileWriter("C:\\Users\\Dell\\Documents\\Universidad\\7mo semestre\\Sistemas distribuidos\\Proyecto\\reportero\\prueba.json");

		        
		        obj.put("Agente", age);
			    obj.put("Fecha", fecha);
			    obj.put("Lectura Minima", "");
			    obj.put("Lectura Maxima","");
			    obj.put("Lectura Mediana", "");

		        
		        file.write(obj.toJSONString());
		        
		        file.flush();
			    
	            }
	        server.close();

	        
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Throwable t){
	        t.printStackTrace();
	      }
		
		System.out.println(obj);
	}

}

