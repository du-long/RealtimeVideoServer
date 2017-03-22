package com.draw;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;

import javax.swing.JPanel;


public class ImagePanel extends JPanel {
	    private Image  image;
	    public InputStream ins;

	    public void getimage(Image  image) {

	        	this.image = image;
	    }
	    
	    public void paintComponent(Graphics g){  
	        super.paintComponent(g);    
	        if (image == null) return;
	        
	        g.drawImage(image, 0, 0, null);
	       /* Graphics2D gg= (Graphics2D)g.create();
            int iw = image.getWidth(), ih = image.getHeight();
            int anchorX = (getWidth()- iw)>>1, anchorY = (getHeight() - ih)>>1;
            AffineTransform af = gg.getTransform();
            af.translate(anchorX, anchorY);
            af.concatenate(trans);
            gg.drawImage(image,af,this);
            gg.dispose();*/
	    }
	    
	  

}
