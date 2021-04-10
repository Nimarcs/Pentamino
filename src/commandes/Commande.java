package commandes;

import java.io.Serializable;

public abstract class Commande implements Serializable {

    private String alias;

    public Commande(String alias) {
        this.alias = alias;
    }

    /**
     * Méthode affichant l'aide sur une commande, comment l'utiliser.
     */
    public abstract void afficherAide();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        return alias != null ? alias.equals(commande.alias) : commande.alias == null;
    }

    /**
     * getter sur alias
     * @return alias de la commande
     */
    public String getAlias() { return this.alias; }

    /**
     * Méthode ayant pour but de communiquer une erreur à l'utilisateur
     * @param message message a envoyé à l'utilisateur
     */
    public void erreur(String message) {
        System.out.println("[ERREUR]: " + message);
        this.afficherAide();
    }

    @Override
    public int hashCode() {
        return alias != null ? alias.hashCode() : 0;
    }

    /**
     * Méthode ayant pour but de communiquer une information à l'utilisateur, comme une bonne exécution de la commande par exemple
     * @param info
     */
    protected void info(String info) {
        System.out.println("[INFO]: " + info);
    }
}
