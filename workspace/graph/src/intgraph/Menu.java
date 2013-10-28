package intgraph;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	JButton br, bj, bv;
	JPanel panel;
	JFrame fenetre;
	JMenuItem menuRouge, menuVert, menuJaune;
	JMenuBar barreMenu;
	JMenu mnuCouleurs;
	
	public Menu() {


		fenetre = new JFrame();
		fenetre.setBounds (0,0,300,400);
		barreMenu = new JMenuBar();
		mnuCouleurs = new JMenu ("Couleurs");
		barreMenu.add(mnuCouleurs);
		menuRouge = new JMenuItem("Rouge");
		menuJaune = new JMenuItem("Jaune");
		menuVert = new JMenuItem("Vert");
		
		mnuCouleurs.add(menuRouge);
		mnuCouleurs.add(menuJaune);
		mnuCouleurs.add(menuVert);
		EcouteurCouleur ec = new EcouteurCouleur();
		
		menuRouge.addActionListener(ec);
		menuJaune.addActionListener(ec);
		menuVert.addActionListener(ec);
		
		panel = new JPanel();
		panel.add(barreMenu);
		menuRouge.addActionListener(ec);
		menuJaune.addActionListener(ec);
		menuVert.addActionListener(ec);
		
		panel.add(barreMenu);
		
		fenetre.getContentPane().add(panel);
		fenetre.addWindowListener(new WindowAdapter()
		{	
			public void windowClosing(WindowEvent arg)
			{
				System.out.println ("window is closing...");
				System.exit(0);
			}
		}
		);
	}
		public class EcouteurCouleur implements ActionListener
		{
			public void actionPerformed (ActionEvent e)
			{
				if (e.getSource() == br)
				{
					panel.setBackground(Color.RED);
				}
				if (e.getSource() == bv)
				{
					panel.setBackground (Color.GREEN);
				}
				if (e.getSource() == bj)
				{
					panel.setBackground (Color.YELLOW);
				}
			}
		}
}

