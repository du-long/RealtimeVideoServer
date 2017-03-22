package com.socket;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.imageio.ImageIO;

import com.draw.SavePicture;

public class ThreadClient implements Runnable , Serializable {
	private BufferedImage bufferedImage;
	private String url;
	public ThreadClient(BufferedImage  image,String url){
		this.bufferedImage = image;
		this.url = url;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket();
			s.connect(new InetSocketAddress(url, 40000), 3000);
			if(s.isConnected() && !s.isClosed()){
				OutputStream oos = s.getOutputStream();				
	
				ImageIO.write(bufferedImage,"JPG",oos);
				oos.write("\n".getBytes());
			
				oos.flush();
				oos.close();
				s.close();
			}

		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
