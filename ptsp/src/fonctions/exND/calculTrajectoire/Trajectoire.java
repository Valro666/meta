package fonctions.exND.calculTrajectoire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Trajectoire extends JPanel{

	/**
	 * la liste des points à afficher
	 */
	ArrayList<Double>[] points;
	
	/**
	 * construit un afficheur à partie liste de points
	 * @param tab liste de points à afficher
	 */
	public Trajectoire(ArrayList<Double>[] tab)
	{
		this.points=tab;
		
		this.setPreferredSize(new Dimension(400,400));
		
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(this);
		f.pack();
		f.setVisible(true);
	}
	
	/**
	 * surcharge de afficahge
	 */
	public void paint(Graphics g)
	{
		//efface
		super.paint(g);
		
		//les couleurs
		Color tab[]={Color.blue,Color.green,Color.red,Color.cyan,Color.magenta};
		
		int ax=0+100;
		int ay=0+100;
		
		//affiche trajectoire
		for(int i=0;i<this.points[0].size();i++)
		{
			int nx=(int)(double)(this.points[0].get(i))+100;
			int ny=(int)(double)(this.points[1].get(i))+100;
			g.setColor(tab[i/10]);
			g.drawLine(ax, ay,nx,ny);
			ax=nx;
			ay=ny;
			
		}
		
	}
	
	
}
