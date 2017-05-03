package rendu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fonctions.Fonction1D;

/**
 * permet d'afficher une fonction à 1 dimension
 * 
 * appeler le méthode affiche en passant les param de x et de y
 * 
 * @author vthomas
 *
 */
public class afficheFonction1D extends JPanel{
	
	/**
	 * la fonction à afficher
	 */
	Fonction1D f;
	
	/**
	 * fenetre à afficher
	 */
	double x0,x1,y0,y1;
	
	/**
	 * construit l'afficheur
	 * @param f fonction à afficher
	 */
	public afficheFonction1D(Fonction1D f)
	{
		this.f=f;
		setPreferredSize(new Dimension(800,600));
	}
	
	/**
	 * permet d'afficher la fonction entre 
	 * @param x0 debut selon axe x
	 * @param x1 fin selon axe x
	 * @param y0 debut selon axe y
	 * @param y1 fin selon axe y
	 */
	public void affiche(double x0,double x1,double y0, double y1)
	{
		//met à jour taille de la fenetre 
		this.x0=x0;
		this.x1=x1;
		this.y0=y0;
		this.y1=y1;
		
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
		frame.repaint();
		
		
	}

	@Override
	/**
	 *redefinit la méthode d'affichafe du JPAnel
	 *permet d'afficher la fonction 
	 */
	public void paint(Graphics g) {
		super.paint(g);
		
		//permet de gerer l'ancien point à afficher
		int[] ancien={-100,-100};
		
		//dessine les axes 
		dessineAxes(g);
				
		
		g.setColor(Color.red);
		//effectue l'affichage de la fonction
		for (int i=0;i<getWidth();i++)
		{
			//evalue x correspondant
			int[] pix={i,0};
			double[] coord=PixToCoord(pix);
			
			//appelle fonction pour point selon axe y
			coord[1]=f.evaluer(coord[0]);
			
			//revient dans espace image
			pix=CoordToPix(coord);			
			
			//trace le trait
			g.drawLine(ancien[0], ancien[1], pix[0], pix[1]);
			ancien=pix;
		}
		
	}

	private void dessineAxes(Graphics g) {
		g.setColor(Color.black);
		
		//trace axes
		double[] origine={0,0};
		double[] axeX={1,0};
		double[] axeY={0,1};
		
		int[] pixOrig=CoordToPix(origine);
		int[] pixAxeX=CoordToPix(axeX);
		int[] pixAxeY=CoordToPix(axeY);
		
		g.drawLine(pixOrig[0], pixOrig[1], pixAxeX[0], pixAxeX[1]);
		g.drawLine(pixOrig[0], pixOrig[1], pixAxeY[0], pixAxeY[1]);
	}
	
	/**
	 * methode qui change les pixels en coordonnées en 2D 
	 * @return les coordonneées dans l'espace 2D
	 */
	private double[] PixToCoord(int[] pix)
	{
		//valeur de retour
		double[] coord=new double[2];
		
		//calcul des coordonnées en fonction de la fenetre affichée
		coord[0]=x0+(pix[0]*(x1-x0))/this.getWidth();
		coord[1]=y0+((this.getHeight()-pix[1])*(y1-y0))/this.getHeight();
		
		return(coord);
	}
	
	/**
	 * methode qui change les coordonnées en coordonnées pixel
	 * @return les coordonneées dans l'image
	 */
	private int[] CoordToPix(double[] coord)
	{
		//valeur de retour
		int[] pix=new int[2];
		
		//calcul des coordonnées en fonction de la fenetre affichée
		pix[0]=(int)(((x0-coord[0])/(x0-x1))*this.getWidth());
		pix[1]=this.getHeight()-(int)(((y0-coord[1])/(y0-y1))*this.getHeight());
		
		return(pix);
		
	}
	
	

}
