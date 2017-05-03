

import java.io.IOException;

import algos.algo1D.AbstractAlgo1D;
import algos.algo1D.DescenteGradient;
import algos.algo1D.Encadrement;
import algos.algo1D.FactoryAlgo1D;
import algos.algo1D.Log;
import fonctions.Fonction1D;
import fonctions.ex1D.Sinus;

/**
 * test pour l'encradement de la fonction sinus
 * 
 * @author vthomas
 * 
 */
public class TestMinimisationSinus {

	public static void main(String[] args) throws IOException {

		// fonction de test
		Fonction1D f = new Sinus();

		// pour chaque algo
		String[] algos = { "descenteGradient", "descenteGradientAlphaGrand", "encadrement" };

		// boucle
		for (String algo : algos) {
			// recupere algorithme par factory
			AbstractAlgo1D algorithme = FactoryAlgo1D.getAlgo(f, algo, -0.2);

			// lancemnt de la recherche entre 0.2 et Math.PI
			Log log = algorithme.minimiser(100);

			// affiche le resultats
			System.out.println("\n\n **** Algo " + algo);
			// normalement la derniere valeur est proche de Math.PI/2
			System.out.println("valeur attendue: " + -1 * Math.PI / 2 + " -> "
					+ new Sinus().evaluer(-1 * Math.PI / 2));
			System.out.println("valeur obtenue : "
					+ log.lastPos() + " -> "
					+ log.lastVal());

			//sauve dans un fichier
			log.exporte(algo+".dat");
		}
	}

}
