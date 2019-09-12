package cipher;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

public class gameBoard extends JFrame implements ActionListener {


	static Scanner sc= new Scanner (System.in);
    JButton att1, att2, deck;
    JLabel h1, s, h2, s1;
    ImageIcon st, st2, bac;
    Image i, img;
    String answer= "";    
    
    static avatar overlord;
    static avatar galaxy;
    
    gameBoard() {
    	overlord= new avatar(100, 100, 100);
    	galaxy= new avatar(100, 100, 100);

        //Image for background
        bac= new ImageIcon(getClass().getResource("cf.png"));
        i= bac.getImage();
        img= i.getScaledInstance(510, 270, Image.SCALE_SMOOTH);
        bac=new ImageIcon(img);

       //Image for Stain and Scaling
        st= new ImageIcon(getClass().getResource("Yugioh - Galaxy Eyes Photon Dragon.jpg"));
        i= st.getImage();
        img= i.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        st= new ImageIcon(img);
        s= new JLabel(st);

        //Stain Stats
        att1= new JButton("Galaxy's Attack");
        att1.addActionListener(this);
        h1= new JLabel("Galaxy's Health: " + galaxy.getHealth());
        
        //Allmight Stats
        att2= new JButton("Overlord's Attack");
        att2.addActionListener(this);
        h2= new JLabel("Overlord's Health: " + overlord.getHealth());

        //Image for Allmight and Scaling
        st2= new ImageIcon(getClass().getResource("Kagero.jpg"));
        i= st2.getImage();
        img= i.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        st2= new ImageIcon(img);
        s1= new JLabel(st2);
        
        deck= new JButton("Deck");
        deck.addActionListener(this);
       
        // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane
        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel ();
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area
        JPanel south= new JPanel();
        south.setLayout (new FlowLayout());
        JPanel center= new JPanel();
        center.setLayout (new FlowLayout());

        north.add(att1);
        north.add(h1);
        center.add(s);
        
        center.add(s1);
        south.add(att2);
        south.add(h2);
        
        south.add(deck);
        
    
        content.add (north, "North"); // Input area
        content.add (center, "Center");
        content.add (south, "South"); // Input area

   

        // 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("Vetrix");
        setSize (510, 320);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
    }
    

    class ImagePanel extends JComponent {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    public void actionPerformed (ActionEvent e)
    {
    	if (e.getActionCommand ().equals ("Galaxy's Attack"))//if Simulate is pressed
        {
    		
    		
   		overlord.avatarIsAttacked(galaxy.getAttack());
  		h1.setText("Overlord's Health: " + overlord.getHealth());
    		
        }
    	else if (e.getActionCommand ().equals ("Overlord's Attack"))//if Simulate is pressed
        {
    		
    		
  		galaxy.avatarIsAttacked(overlord.getAttack());
 		h1.setText("Galaxy's Health: " + galaxy.getHealth());
    		
        }
    	if (e.getActionCommand ().equals ("Deck"))//if Simulate is pressed
        {
    		System.out.println("HEllo");
    		Deck d= new Deck();
    		d.setVisible(true);
        }
    	
        
        
        repaint (); //Refresh display of grid
    }
	
	
}
