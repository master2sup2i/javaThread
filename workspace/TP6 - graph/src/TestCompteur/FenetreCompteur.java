package TestCompteur;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.*;

@SuppressWarnings("serial")
public class FenetreCompteur extends JFrame {

	private JLabel label; 		//label servira pour l'affichage "compteur: 0"
	private JButton inc, dec; 	//les boutons + et -
	private JPanel panel; 		// le container
	private JFrame fenetre;		// la fenetre
	private Compteur cpt;
	public FenetreCompteur()
	{
	fenetre = new JFrame("Counter");
	fenetre.setBounds(0,0,300,200);
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenetre.setResizable(false);
	label = new JLabel("Compteur: 0");
	dec = new JButton ("-");
	inc = new JButton ("+");
	cpt = new Compteur();		
	panel = new JPanel();
	panel.add(label);
	panel.add(dec);						// Ajout des boutons au panel
	panel.add(inc);
	
	
	fenetre.getContentPane().add(panel);// Ajout du panel à la fenetre
	Ecouteur ec = new Ecouteur();		// Creer l'écouteur
	dec.addActionListener(ec);			// Ajoute l'ecouteur aux boutons
	inc.addActionListener(ec);
	fenetre.setVisible(true);
	}
	
public class Ecouteur implements ActionListener
{
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == inc) cpt.Inc();
		else if (e.getSource() == dec) cpt.Dec();
		label.setText("Compteur: "+String.valueOf(cpt.getCompteur()));
		fenetre.validate();
	}
}

}
