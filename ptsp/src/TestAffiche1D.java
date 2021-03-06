

import rendu.afficheFonction1D;
import fonctions.Fonction1D;
import fonctions.ex1D.Sinus;

/**
 * permet de verifier affichage courbe 1D
 * 
 * @author vthomas
 * 
 */
public class TestAffiche1D {

	public static void main(String[] args) {
		// créé la fonction sinus
		Fonction1D f = new Sinus();
		
		//creer un afficheur
		afficheFonction1D affiche=new afficheFonction1D(f);
		
		//lance l'affichage
		//entre -Pi et Pi et -1 et 1
		affiche.affiche(-Math.PI, Math.PI, -1.5, 1.5);

	}

}
