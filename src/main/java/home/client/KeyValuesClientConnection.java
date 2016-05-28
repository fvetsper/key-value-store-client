package home.client;

import home.commons.Request;
import home.commons.Response;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class KeyValuesClientConnection {

	
	private String host;
	private int port;
	
	public KeyValuesClientConnection(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public Response send(Request request) {
		Response response = null;
		try {
			Socket socket = new Socket(host, port);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());

			ObjectMapper mapper = new ObjectMapper();
			String rjson = mapper.writeValueAsString(request);
			
			dos.writeUTF(rjson);
			dos.flush();
			
			String wjson = dis.readUTF();
			
			if (wjson != null && wjson.length() > 0) {
				response = mapper.readValue(wjson, Response.class);
			}
			
			dis.close();
			dos.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + host);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + host);
		}
		return response;
	}
	
}
