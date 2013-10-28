package TestListe;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.*;

public class TestListe extends JFrame
{
	
	JComboBox ListeBG, ListeColor;
	JScrollPane defil;
	JFrame fenetre;
	JPanel panel;
	EcouteurListe ec;
	
	public TestListe()
	{
		String[] ColorBG = {"RED", "GREEN","BLUE", "YELLOW"};
		String[] ColorTxt = {"RED", "GREEN","BLUE", "YELLOW"};
		fenetre = new JFrame ("Color Text & BG");
		fenetre.setBounds(10,40,300,200);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
		
		ListeBG = new JComboBox(ColorBG);
		ListeBG.setSelectedIndex(2);
		ListeColor = new JComboBox(ColorTxt);
		ListeColor.setSelectedIndex(2);

		
		//menu Depliant
		ListeBG.setMaximumRowCount(3);
		ListeColor.setMaximumRowCount(3);
		ec = new EcouteurListe();
		ListeBG.addActionListener(ec);
		ListeColor.addActionListener(ec);
		panel = new JPanel();
		panel.add(ListeBG);
		fenetre.getContentPane().add(panel);
		fenetre.setVisible(true);
	
		
	}
	
	
	public class EcouteurListe implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
		if (e.getSource()==ListeBG)
			{
			if (ListeBG.getSelectedItem() == "GREEN") panel.setBackground(Color.GREEN);
			else if (ListeBG.getSelectedItem() == "RED") panel.setBackground(Color.RED);
			else if (ListeBG.getSelectedItem() == "BLUE") panel.setBackground(Color.BLUE);
			else if (ListeBG.getSelectedItem() == "YELLOW") panel.setBackground(Color.YELLOW);
			fenetre.validate();
			}
		}
	}
	
}
	
	
	

