package cipher;

import java.awt.*;
import javax.imageio.*; // allows image loading
import java.io.*; // allows file access
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener
import java.util.Random;
import java.util.* ;

public class cardDeck {

	 protected ArrayList<Cards> deck;//creates an arraylist called deck that contains Cards values
	    
	    public cardDeck()//constructor
	    {
	        deck= new ArrayList<Cards>(16);//creates a deck arraylist of size 52
	        for( int x= 0; x < 16; x ++ )//declare x as 0; loop so long as x is less than 52; add x by 1
	            deck.add(new Cards(x + 1));//deck[x] is equal to Cards(x)
	    }
	    
	     public void show (Graphics g)  // draws card face up or face down
	    {
	        int x= 0;//declare as 0
	        for ( Cards c : deck )//wrap c as equal to deck
	        {
	            c.show (g, x%4*100 , x/4*100); //display card as face up or facedown
	            x ++;
	        }
	    }


	    public void shuffle ()//method called shuffle
	    {
	        Random r= new Random();//applies Random
	        int temp1, temp2;//declare as int
	        Cards temp3;//declare as Cards
	        ArrayList<Cards> temp= new ArrayList<Cards>(deck.size());//declare as an array of data type Cards with length of deck.length
	        
	        for( int x= 0; x < deck.size()*3; x ++ )//declare as int; loop so long as x is less than deck.length; add x by 1
	        {//if true, then...
	            temp1= r.nextInt(deck.size());//temp1 is equal to random number between 0 and 51
	            temp2= r.nextInt(deck.size());//temp2 is equal to random number between 0 and 51
	            temp3= deck.get(temp1);//temp3 is equal to deck[temp1]
	            deck.set(temp1,deck.get(temp2));//deck[temp1] is equal to deck[temp2]
	            deck.set(temp2, temp3);//deck[temp2] is equal to temp3
	        }
	    }
	    
	    public Cards deal()//method called deal()
	    {
	          Cards temp= deck.get(0);//declare temp as equal to the 0th index of deck
	          deck.remove(0);//remove the 0th index from deck
	          return temp;//return temp
	    }
	    
	    public Cards deal( int index )//method called deal
	    {
	        if( index > 0 && index <= deck.size() )//determines whether index is greater than or equal to 0 or less than or equal to deck.size()
	        {
	          Cards temp= deck.get(index);//temp is equal to deck.get(index)
	          deck.remove(index);//remove value at index from deck
	          return temp;//return temp
	        }
	        
	        return deal();//return deal()
	    }
	    
	    public void add( Cards card )//method called add
	    {
	          deck.add( card );//add card to end of deck
	    }
	    
	    public ArrayList<Integer> search( Cards card )//method called search
	    {
	          ArrayList<Integer> sea= new ArrayList<Integer>();//create arraylist sea with datafields Integer
	          int x =0;//declare as 0
	          for( Cards car: deck )//wrap car as equal to the values of deck as it loops
	          {
	              if( car.equals(card) )//determines whether car equals card
	              {
	                  sea.add(x);//add x to sea
	              }
	              else//however, if not true
	              {
	                  deck.get(x).flip();//flip the card at deck.get(x)
	              }
	              
	              x ++;//add x by 1
	          }
	          
	          return sea;//return sea
	    }
	    
	    public int getLength()//method called getLength
	    {
	        return deck.size();//returns deck.size()
	    }
	    
	    private void exchangeNumbers(int i, int j)//method called exchangeNumbers
	    {
	        Cards temp = deck.get(i);//temp is equal to deck.get(i)
	        deck.set(i, deck.get(j));//replace value at index i to deck.get(j)
	        deck.set(j, temp);//deck[j] is equal to temp
	    }

	  
	    
	    public void selectionSort()//method called selectionSort
	    {
	        
	         for ( int j = 0; j < deck.size()-1; j ++ )//declare as 0; loop so long as j is less than deck.length - 1; add j by 1
	      {
	        // Find min: the index of the integer that should go into cell j.
	        // Look through the unsorted integers (those at j or higher)
	        int min = j;//declare as j
	        for ( int k = j+1; k < deck.size(); k ++ )//declare as j + 1; loop so long as k is less than deck.length; add k by 1
	        {
	          if ( deck.get(min).CardNum() > deck.get(k).CardNum() )//determines whether deck[min].CsrdNum() is greater than deck[k].CardNum()
	              min = k;//min is equal to k
	        }
	        // Swap the int at j with the int at min 
	        Cards temp = deck.get(j);//temp is equal to deck[j]
	        deck.set(j, deck.get(min));//deck[j] is equal to deck[min]
	        deck.set(min, temp);//deck[min] is equal to temp
	      }
	        
	    }
	
}
