import generic.AlgorithmeAbstract;
import probleme.quatreCouleurs.Probleme4Couleurs;
import probleme.quatreCouleurs.Solution4Couleurs;

import probleme.TSP.SolutionTSP;
import probleme.TSP.TSP;
import java.util.Properties;

/**
 * permet de tester tous les algorithmes
 * @author vthomas
 *
 */
public class TestsTous {
	
    public static void main(String[] args){

	Properties parametres = readProperties("parametres.properties");
	if(args.length > 0)
       	    parametres = readProperties(args[1]);

	// read parameters
	int maxEvaluations = 10000;
	String s;
	if ((s = parametres.getProperty("maxEvaluations")) != null) 
	    maxEvaluations = Integer.parseInt(s) ;

	
	// Choix du probleme 
	//Probleme4Couleurs probleme  = new Probleme4Couleurs(20);
	//Solution4Couleurs solution  = new Solution4Couleurs(probleme);
	
	TSP probleme         = new TSP(100,400);
	SolutionTSP solution = new SolutionTSP(probleme);
		
	String[] algo={"greedy", "recuit", "sls"};
		
	//pour chaque algo
	for (int i=0;i<algo.length;i++){

	    // remettre le nombre d'eval a zero
	    probleme.resetNbEvaluations();
	    
	    //affiche
	    System.out.println("\n\n\n\n ******************\n"+algo[i]+"\n");
	    
	    
	    // recupetrer algorithme
	    
	    AlgorithmeAbstract algorithme=
		AlgorithmeAbstract.getAlgo(algo[i], probleme, solution,
					   maxEvaluations);
			
	    //execution
	    algorithme.executeJusquaFin();
	
			
	}
    }
	
 /**
     *  Lecture du fichier de parametres 
     */

    private static Properties readProperties(String fileName) {
	Properties properties = new Properties();
	try {
            java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
            properties.load(fis);
            fis.close();
        } 
        catch(java.io.IOException e) { 
            System.out.println("File '" + fileName + "' not found, no options read");
            e.printStackTrace();
	    System.exit(1);
        }
	
        return properties;
    }
    

}
