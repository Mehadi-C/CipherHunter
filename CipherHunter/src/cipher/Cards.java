package cipher;

import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.*;

public class Cards {
	
	ArrayList <Integer> deck;
     protected boolean faceup;
	 private static Image cardback;
	 private Image image, scale;
	 ImageIcon i, ca;
	 private int CardNum;
	 
	 
		 
	Cards(int c){
		
		int cardNum= c;
		 faceup= true;//faceup is equal to true
	        
	        image = null;//image is equal to null
	      
	     i= new ImageIcon(getClass().getResource(cardNum + ".jpg"));
	     image= i.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	     
	     ca= new ImageIcon(getClass().getResource("b.jpg"));
	     cardback= ca.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	        
	}
	
	public void show (Graphics g, int x, int y)  // draws card face up or face down
    {
        if (faceup)
            g.drawImage (image, x + 14 , y + 13, null);
        else
            g.drawImage (cardback, x + 12, y + 12, null);

    }
	
	public int CardNum()//method called CardNum
    {
        return CardNum;//returns CardNum
    }
    
    public boolean getFaceup()//method called getFaceup
    {
        return faceup;//return faceup
    }
    
    public void flip()//method called flip
    {
        if( faceup == true )//determines if faceup is equal to true
            faceup= false;//faceup is equal to false
        else//however, if not true
            faceup= true;//faceup is equal to true
    }
    

}
