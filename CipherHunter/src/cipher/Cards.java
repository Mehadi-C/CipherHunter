package cipher;

import java.awt.*;
import javax.imageio.*; // allows image loading
import java.io.*; // allows file access
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

class cards
{
	Image image;
	ArrayList<Image> spot = new ArrayList<Image>(20);
	int[] d = new int[20];
	private static final Random ran = new Random();
	public cards() throws IOException{
		//deck with 4 of 5 different cards. the array is to get the number of each card.
		for(int i =0; i<4; i++) {spot.add(create(1));}
		for(int i =0; i<4; i++) {spot.add(create(2));}
		for(int i =0; i<4; i++) {spot.add(create(3));}
		for(int i =0; i<4; i++) {spot.add(create(4));}
		for(int i =0; i<4; i++) {spot.add(create(5));}
		for(int i =0; i<20; i++) {d[i] = converttonum(spot.get(i));}
		
	}
	public int random()//randomly get a card
	{
		return ran.nextInt(5)+1;
	}
	public Image create(int num) throws IOException//convert number to image
	{
		if(num == 1) {image = ImageIO.read (new File ("Groudon&Kyogre.jpg"));}
		else if(num==2) {image = ImageIO.read (new File ("Yugioh - Galaxy Eyes Photon Dragon.jpg"));}
		else if(num==3) {image = ImageIO.read (new File ("Kagero.jpg"));}
		else if(num==4) {image = ImageIO.read (new File ("Ul Goku.jpg"));}
		else if(num==5) {image = ImageIO.read (new File ("Blue-Eyes_Solid_Dragon_water_800x.jpg"));}
		return image;
	}
	public int converttonum(Image m) throws IOException//convert image to number
	{
		
		int num = 0;
		if(m == ImageIO.read (new File ("Groudon&Kyogre.jpg"))) {num = 1;}
		else if(m == ImageIO.read (new File ("Yugioh - Galaxy Eyes Photon Dragon.jpg"))) {num = 2;}
		else if(m == ImageIO.read (new File ("Kagero.jpg"))) {num = 3;}
		else if(m == ImageIO.read (new File ("Ul Goku.jpg"))) {num = 4;}
		else if(m == ImageIO.read (new File ("Blue-Eyes_Solid_Dragon_water_800x.jpg"))) {num = 5;}
		return num;
	}
	public void show()//display
	{
	//if the cards are in your hand, then it would reveal. if the cards are not in your hand, then it would be cover
	}
	public void shuffle() throws IOException//shuffle the deck and the array will also shuffle
	{
		Collections.shuffle(spot);
		for(int i =0; i<20; i++) {d[i] = converttonum(spot.get(i));}
	}
}