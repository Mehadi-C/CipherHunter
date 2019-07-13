package cipher;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

public class Deck extends JFrame implements ActionListener {


	Scanner sc= new Scanner (System.in);
	JButton shuffle, ad, discard;
	
	  //declare static datafields
    static cardDeck deck = new cardDeck ();
    static Cards card;

    //======================================================== constructor
    public Deck ()
    {
        
        //setting the buttons on to the window with their string equivalent and btnListener in order to call events
        JButton shuffleBtn = new JButton ("Shuffle");
        shuffleBtn.addActionListener (this);
        JButton sortsBtn = new JButton ("Sort Suit");
        sortsBtn.addActionListener (this);
        

        
        
        // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane
        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel (); // where the buttons, etc. will be
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area

        DrawArea board = new DrawArea (1000, 1010); // Area for cards to be displayed

        // 3... Add the components to the input area.
        north.add (shuffleBtn);                     
        north.add (sortsBtn);
        content.add (north, "North"); // Input area
        content.add (board, "South"); // Deck display area

        // 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("Deck Demo");
        setSize (1000, 1000);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
    }

    // put ActionListener class for your buttons here
    
        public void actionPerformed (ActionEvent e)
        {
            
            //determines whether the ActionCommand is equal to the String equivalent of the buttons pressed (determines whether button is pressed)
            //if true, then the respected methods are called from card
            if (e.getActionCommand ().equals ("Shuffle"))//if shuffle is pressed
                deck.shuffle (); // shuffle deck
            else if( e.getActionCommand().equals("Sort Suit"))//if Sort Suit is pressed
                deck.selectionSort(); // sort suit and ranks of cards using selectionSort
            
            
            repaint (); // do after each action taken to update deck
        }
 

    class DrawArea extends JPanel//display cards
    {
        public DrawArea (int width, int height)
        {
            this.setPreferredSize (new Dimension (width, height)); // size
        }

        public void paintComponent (Graphics g)
        {
            deck.show (g);
        }
    }
	
	
}
