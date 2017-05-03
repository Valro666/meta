package algos.algo1D;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Log {

	// permet de stocker les resultats
	ArrayList<Double> positions;
	ArrayList<Double> valeurs;

	/**
	 * constructeur vide iitialise
	 */
	public Log() {
		positions = new ArrayList<Double>();
		valeurs = new ArrayList<Double>();
	}

	/**
	 * permet de logguer une valeur et une position
	 * 
	 * @param pos
	 *            la position
	 * @param valeur
	 *            la valeur associée
	 */
	public void ajoute(double pos, double valeur) {
		positions.add(pos);
		valeurs.add(valeur);
	}

	/**
	 * @return derniere valeur
	 */
	public double lastVal() {
		return valeurs.get(valeurs.size() - 1);
	}

	/**
	 * @return derniere position
	 */
	public double lastPos() {
		return positions.get(positions.size() - 1);
	}

	/**
	 * exporte dans un fichier
	 * 
	 * @param name
	 *            nom du fichier
	 * @throws IOException
	 */
	public void exporte(String name) throws IOException {
		BufferedWriter bf = new BufferedWriter(new FileWriter(new File(name)));
		for (int i = 0; i < positions.size(); i++) {
			bf.write("" + positions.get(i) + " " + valeurs.get(i));
			bf.newLine();
		}
		bf.close();
	}

	@Override
	public String toString() {

		return "Log [positions=" + positions + ", valeurs=" + valeurs + "]";
	}

}
