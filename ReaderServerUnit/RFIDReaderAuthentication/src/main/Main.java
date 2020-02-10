package main;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.*; 
import java.io.*; 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetupChannel();
	}

	private static void SetupChannel() {
		
		Server server = new Server(5000);
		//Generate {Ci, Cem}
		//Send {Ci, Cem} to tag
		//Listen for {Ri, Rem{
		//Generate TIDit
		//Generate PID = {pid1, pid1,...,pidn}
		//Store {TIDiT, (Ci,Ri), (Cem, Rem), PID}
		//Send {TIDit, PID} to Tag
	}
	
	@SuppressWarnings("unused")
	private void EstablishConnection(int port) {
		Socket          socket   = null; 
	    ServerSocket    server   = null; 
	    DataInputStream inputStream = null; 
	    DataOutputStream outputStream     = null; 
	    
		try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
  
            // takes input from the client socket 
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
            
            outputStream = new DataOutputStream(socket.getOutputStream()); 
  
            String line = ""; 
  
            // reads message from client until "Over" is sent 
            while (!line.equals("Over")) 
            { 
                try
                { 
                    line = inputStream.readUTF(); 
                    System.out.println(line); 
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            } 
            System.out.println("Closing connection"); 
  
            // close connection 
            socket.close(); 
            inputStream.close(); 
            outputStream.close();
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
	}
	private void Authenticate() {
		
	}
}
