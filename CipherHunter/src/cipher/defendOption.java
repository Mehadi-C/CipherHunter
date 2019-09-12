package cipher;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener


public class defendOption extends JFrame implements ActionListener {
	
	JButton y, n;
	JLabel lab;
	String answer= "";
	
	defendOption(){
		lab= new JLabel("Will opponent defend?");
		y= new JButton("Yes");
		n= new JButton("No");
		
		  // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane
        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel ();
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area
        JPanel south= new JPanel();
        south.setLayout (new FlowLayout());
        JPanel center= new JPanel();
        center.setLayout (new FlowLayout());
        
        north.add(lab);
        center.add(y);
        center.add(n);
        
        content.add (north, "North"); // Input area
        content.add (center, "Center");
        content.add (south, "South"); // Input area
		
		// 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("TCG");
        setSize (210, 120);
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
	}
	
	

	  public void actionPerformed (ActionEvent e)
	    {
	    	if (e.getActionCommand ().equals ("Yes"))//if Simulate is pressed
	        {
	    		setVisible(false);
	        }
	    	if (e.getActionCommand ().equals ("No"))//if Simulate is pressed
	        {
	    		setVisible(false);
	        }
	    	repaint();//Refresh display of grid
	    }
		
}
