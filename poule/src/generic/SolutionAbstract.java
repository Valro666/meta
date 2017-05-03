package generic;


import java.util.List;

/**
 * solution abstraite depend du probleme traité
 *
 */

public abstract class SolutionAbstract {

    
    // Retourne le voisinage complet sous forme de liste
    public abstract List<SolutionAbstract> retourneVoisinage();
    
    // Retourne un voisin au hasard 
    public abstract SolutionAbstract retourneVoisinHasard();
    
    // Retourne une perturbation de la solution +/- forte en fonction de n
    public abstract SolutionAbstract retournePerturbation (int n);
    
}
