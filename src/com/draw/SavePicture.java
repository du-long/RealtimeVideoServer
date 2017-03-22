package com.draw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class SavePicture {
	public void save(BufferedImage bufferedImage){
		String fileName ="D:/images/"+ new Date().getTime();
		try {
			if(ImageIO.write(bufferedImage, "jpg", new File(fileName))){
				System.out.println("save picture success!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
