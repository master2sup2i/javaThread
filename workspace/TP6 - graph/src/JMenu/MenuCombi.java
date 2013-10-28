package JMenu;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.*;

public class MenuCombi extends JFrame
{
	private static final long serialVersionUID = 1L;
	JMenu MenuCouleur,MenuFormes;
	JMenuBar barreMenus;
	JRadioButtonMenuItem rouge,vert;
	JFrame fenetre;
	JPanel panel;
	JCheckBoxMenuItem rectangle,ovale;
	ButtonGroup groupe;
	Ecouteur ec;

	public MenuCombi() 
	{
		barreMenus = new JMenuBar();
		fenetre = new JFrame();
		panel = new JPanel();
		fenetre.setBounds(10,40,300,400);
		fenetre.setTitle("Menu");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//les boutons
		fenetre.setJMenuBar(barreMenus);
		
		//creation d'un menu couleur
		MenuCouleur = new JMenu("Couleurs");		
		ec = new Ecouteur();
		rouge = new JRadioButtonMenuItem("Rouge");
		vert = new JRadioButtonMenuItem("Vert");
		rouge.addActionListener(ec);
		vert.addActionListener(ec);
		groupe = new ButtonGroup();
		groupe.add(rouge);
		groupe.add(vert);
		MenuCouleur.add(rouge);
		MenuCouleur.add(vert);
		barreMenus.add(MenuCouleur);
		
		//creation d'un menu Forme
		MenuFormes = new JMenu("Formes");
		rectangle = new JCheckBoxMenuItem("Rectangle");
		ovale = new JCheckBoxMenuItem("Ovale");
		rectangle.addActionListener(ec);
		ovale.addActionListener(ec);
		MenuFormes.add(rectangle);
		MenuFormes.add(ovale);
		barreMenus.add(MenuFormes);
		
		panel.add(barreMenus);
		
		fenetre.getContentPane().add(panel);
		fenetre.setVisible(true);
		
	}

	public class Ecouteur implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
		if (e.getSource()==rouge) { panel.setBackground(Color.RED);	}
		else if (e.getSource()==vert) {panel.setBackground(Color.GREEN); }
		if (e.getSource()==rectangle) { panel.setBackground(Color.YELLOW);	}
		else if (e.getSource()==ovale) {panel.setBackground(Color.BLACK); }	
		fenetre.validate();
		}
	}
}
	
