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


public class Etiquette {

	public class EcouteurRadio implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			String s = null;
			if (e.getSource() == Frites)
			{
				if (Frites.isSelected())
					s = "Vous avez selectionné frites";
				else
					s = "Vous avez déselectionné frites";
			}
			else 
				if (e.getSource() == Poulet)
				{
					if (Poulet.isSelected())
					s = "Vous avez selectionné poulet";
				else
					s = "Vous avez déselectionné poulet";)
				}
		}
	}
	
}
