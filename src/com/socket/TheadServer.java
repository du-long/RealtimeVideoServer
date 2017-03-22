package com.socket;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

import com.draw.ImageFrame;
import com.draw.SavePicture;

public class TheadServer implements Runnable {
	private static SavePicture sp = new SavePicture();
	private Socket s = null;
	public static ImageFrame frame = null;
	private BufferedImage bufferedImage;
    public InputStream ins;
    
    private final static String urla = "10.0.56.221" ; //手机A
    private final static String urlb = "10.0.56.238" ; //手机B
    
	public TheadServer(ServerSocket ss ,ImageFrame imageFrame) throws IOException{
		this.s=ss.accept();
		TheadServer.frame=imageFrame;		
		
		
	}

	@Override
	public void run(){	
		try {	
			String adress = s.getInetAddress().toString();
			adress = getip(adress);
			if((adress).equals(urla)){
				
				ins = s.getInputStream();
				bufferedImage = ImageIO.read(ins);
				ins.close();
				
				BufferedImage bi = rotate90DX(bufferedImage);
				
				//sp.save(bufferedImage);
				ThreadClient tc = new ThreadClient(bi,urlb);
				new Thread(tc).start();
				
			}else if((adress).equals(urlb)){
				ins = s.getInputStream();
				bufferedImage = ImageIO.read(ins);				
				ins.close();
				
				BufferedImage bi  = rotate90DX(bufferedImage);
				
				ThreadClient tc = new ThreadClient(bi,urla);
				new Thread(tc).start();
				ImageFrame.panel.getimage(bi);
				frame.repaint();
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			try {
				if(!s.isClosed())
					s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public String getip(String adress){
		int pos = adress.lastIndexOf("/");
		
		return adress.substring(pos+1);
	}

	//逆时针旋转90度
	public BufferedImage rotate90DX(BufferedImage bi) 
	{ 
	    int width = bi.getWidth(); 
	    int height = bi.getHeight(); 
	      
	    BufferedImage biFlip = new BufferedImage(height, width, bi.getType()); 
	      
	    for(int i=0; i<width; i++)
	        for(int j=0; j<height; j++) 
	            biFlip.setRGB(height-1-j, width-1-i, bi.getRGB(i, j)); 
	      
	    return biFlip; 
	} 
	
	//顺时针旋转90度
	public BufferedImage rotate90SX(BufferedImage bi) {  
		int width = bi.getWidth();
	    int height = bi.getHeight();
	     
	    BufferedImage biFlip = new BufferedImage(height, width, bi.getType());
	    
	    for(int i=0; i<width; i++)
	        for(int j=0; j<height; j++)
	            biFlip.setRGB(j, i, bi.getRGB(i, j));
	    return biFlip;
	} 

}
