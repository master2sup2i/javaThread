package Recap;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import JMenu.MenuCombi.Ecouteur;

 
public class Scroll extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox liste;
	Ecouteur ec;
	JPanel panel;
	JFrame fenetre;
	JTextField champTexte;
	JButton bouton;
	JCheckBox caseACocher;

	public Scroll()
	{ 
		fenetre = new JFrame();
		fenetre.setTitle("Combo Box et autres"); //On donne un titre à l'application
		fenetre.setSize(320,240); //On donne une taille à notre fenêtre
		fenetre.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		fenetre.setResizable(true); //On permet le redimensionnement
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		fenetre.setContentPane(buildScroll());
		fenetre.setVisible(true);
	}

	private JPanel buildScroll()
	{ 
		panel = new JPanel();
		String[] elements = {"Bleu", "Rouge", "Vert"};
		liste = new JComboBox(elements);
		panel.add(liste);
		champTexte = new JTextField("du texte",15);
		panel.add(champTexte);
		bouton = new JButton("bouton");
		panel.add(bouton);
		JLabel monLabel = new JLabel("label");  
		panel.add(monLabel);
		caseACocher = new JCheckBox("ok ?",true);
		panel.add(caseACocher);
		ec = new Ecouteur();
		liste.addActionListener(ec);
    	return panel;
	}
    
	public class Ecouteur implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
		if (e.getSource()==liste) { 
			if (liste.getSelectedItem() == "Bleu") {panel.setBackground(Color.BLUE);}
			else if (liste.getSelectedItem() == "Rouge") {panel.setBackground(Color.RED); }
			else if (liste.getSelectedItem() == "Vert") {panel.setBackground(Color.GREEN); }
		}
		fenetre.validate();
		}
	}

}