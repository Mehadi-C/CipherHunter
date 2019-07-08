package cipher;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

public class gameBoard extends JFrame implements ActionListener {


	static Scanner sc= new Scanner (System.in);
    JButton att1, def1, att2, def2;
    JLabel team1, team2, h1, s, h2, s1;
    ImageIcon st, st2, bac;
    Image i, img;
    battle bat= new battle();
    //does it work
    gameBoard() {
        //add team1's title
        team1= new JLabel("Heroclix");
        team2=new JLabel("CyberCorps");

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
        att1= new JButton("Galaxy's Attack: " + bat.stain.getAttack());
        att1.addActionListener(this);
        def1= new JButton("Galaxy's Defence: " + bat.stain.getDefence());
        def1.addActionListener(this);
        h1= new JLabel("Galaxy's Health: " + bat.stain.getHealth());
        
        //Allmight Stats
        att2= new JButton("Overlord's Attack: " + bat.allmight.getAttack());
        att2.addActionListener(this);
        def2= new JButton("Overlord's Defence: " + bat.allmight.getDefence());
        def2.addActionListener(this);
        h2= new JLabel("Overlord's Health: " + bat.allmight.getHealth());

        //Image for Allmight and Scaling
        st2= new ImageIcon(getClass().getResource("Kagero.jpg"));
        i= st2.getImage();
        img= i.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        st2= new ImageIcon(img);
        s1= new JLabel(st2);
       
        // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane
        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel ();
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area
        JPanel south= new JPanel();
        south.setLayout (new FlowLayout());
        JPanel center= new JPanel();
        center.setLayout (new FlowLayout());

        north.add(team1);
        north.add(att1);
        north.add(def1);
        north.add(h1);
        center.add(s);
        
        center.add(s1);
        south.add(att2);
        south.add(def2);
        south.add(h2);
        south.add(team2);
        
    
        content.add (north, "North"); // Input area
        content.add (center, "Center");
        content.add (south, "South"); // Input area

   

        // 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("TCG");
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
        
        repaint (); //Refresh display of grid
    }
	
	
}
