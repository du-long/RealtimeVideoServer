package com.socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.draw.ImageFrame;



public class socketService {
	public static List<Socket> socketList= new ArrayList<Socket>();

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		ServerSocket ss = new ServerSocket(3000);
		System.out.println("begin");
		final ImageFrame frame = new ImageFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
		while(true){

			new Thread(new TheadServer(ss,frame)).start();
		}

	}

}
