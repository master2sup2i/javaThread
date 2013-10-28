package intgraph;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

	@SuppressWarnings("serial")
	public class Bouttons extends JFrame
	{
		JButton br, bj, bv;
		JPanel panel;
		JFrame fenetre;
		JMenuItem menuRouge, menuVert, menuJaune;
		JMenuBar barreMenu;
		JMenu mnuCouleur;
		
		
		public Bouttons ()
		{
			JFrame fenetre;
			fenetre= new JFrame();
			fenetre.setBounds(0,0,300,400);
			fenetre.setTitle("Deuxieme fenetre Java");
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//les boutons
			br = new JButton("Rouge");
			bj = new JButton("Jaune");
			bv = new JButton("Vert");
			
			panel = new JPanel();
			
			//ajouter les boutons
			panel.add(br);
			panel.add(bj);
			panel.add(bv);
			
			//ajouter le conteneur
			fenetre.getContentPane().add(panel);
			fenetre.setVisible(true);
			EcouteurCouleur ec = new EcouteurCouleur();
			br.addActionListener(ec);
			bj.addActionListener(ec);
			bv.addActionListener(ec);
			fenetre.setVisible(true);
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
