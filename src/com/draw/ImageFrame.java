package com.draw;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ImageFrame extends JFrame {
	public static ImagePanel panel;
	
	 public static final int DEFAULT_WIDTH = 640;
	 public static final int DEFAULT_HEIGHT = 560; 
   
    public ImageFrame(){
   	    // get screen dimensions   	   
   	    Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen
        setTitle("视频传输");
        setLocation((screenWidth - DEFAULT_WIDTH) / 2, (screenHeight - DEFAULT_HEIGHT) / 2);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // add panel to frame
        this.getContentPane().setLayout(null);
        panel = new ImagePanel();
        panel.setSize(640,480);
        panel.setLocation(0, 0);
        add(panel);
    }
}
