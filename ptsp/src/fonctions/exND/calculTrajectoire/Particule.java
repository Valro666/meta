package fonctions.exND.calculTrajectoire;

import java.text.DecimalFormat;

public class Particule {

	/**
	 * parametres de la particule
	 */
	double px, py, vy, vx, ay, ax;

	/**
	 * les valeurs maximales d'acceleration
	 * en pixel par secondes
	 */
	static final double MAXX = 100;
	static final double MAXY = 100;

	/**
	 * permet de mettre à jour les parametres de la particule modele physique de
	 * mise à jour
	 * 
	 * @param dt
	 *            quantum de temps
	 */
	public void mettreAJour(double dt) {
		// evolution de la vitesse
		this.vx = this.vx + this.ax * dt;
		this.vy = this.vy + this.ay * dt;

		// evolution de la position
		this.px = this.px + this.vx * dt;
		this.py = this.py + this.vy * dt;
	}

	/**
	 * permet de modifier la valeur d'acceleration (avec un seuil qui traine)
	 * 
	 * @param pax
	 *            nouvelle acceleration selon x
	 * @param pay
	 *            nouvelle acceleration selon y
	 */
	public void modifierAcceleration(double pax, double pay) {
		// borner en x
		if (pax > MAXX)
			pax = MAXX;
		if (pax < -MAXX)
			pax = -MAXX;

		// borner en y
		if (pay > MAXY)
			pay = MAXY;
		if (pay < -MAXY)
			pay = -MAXY;

		// mettre à jour
		this.ax = pax;
		this.ay = pay;
	}
	
	/**
	 * permet d'afficher la particule
	 */
	public String toString()
	{
		DecimalFormat df=new DecimalFormat("###.00"); 
		String res="x: "+df.format(this.px)+", y: "+this.py+", vx: "+this.vx+", vy: "+this.vy;
		res+=", ax: "+this.ax+", ay: "+this.ay;
		return(res);
	}
}
