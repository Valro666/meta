import algos.algo1D.Encadrement;
import algos.algo1D.Log;
import fonctions.Fonction1D;
import fonctions.ex1D.Conserve;
import rendu.afficheFonction1D;

public class conserve {

	public static void main(String[] args) {
		// créé la fonction sinus

		Fonction1D c = new Conserve(1000);

		// Fonction1D

		// creer un afficheur
		afficheFonction1D affiche = new afficheFonction1D(c);

		Encadrement e = new Encadrement(c, 0, 6, 10);

		// lance l'affichage
		// entre -Pi et Pi et -1 et 1
		// affiche.affiche(0, 10, -10, 1000);

		Log g = e.minimiser(1000);

		System.out.println(g);

		System.out.println("position/rayon " + g.lastPos() + " valeur/surface " + g.lastVal());

	}

}
