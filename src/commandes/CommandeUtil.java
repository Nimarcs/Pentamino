package commandes;

import java.util.List;

public class CommandeUtil {

    /**
     * Méthode retournant l'indice d'une commande si elle existe
     * @param commandes liste de commandes dans laquelle chercher
     * @param commandeName nom de la commande
     * @return indice correspondant si trouvé, sinon -1
     */
    public static int trouverIndiceCommande(List<? extends Commande> commandes, String commandeName) {
        int indice = -1;
        int i = 0;
        while (indice == -1 && i < commandeName.length()) {
            if(commandeName.equals(commandes.get(i).getAlias())) indice = i;
            else i++;
        }
        return indice;
    }

}
