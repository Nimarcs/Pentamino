package commandes;

public abstract class Commande {

    private String alias;

    public Commande(String alias) {
        this.alias = alias;
    }

    public abstract void executer();
    public abstract void afficherAide();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        return alias != null ? alias.equals(commande.alias) : commande.alias == null;
    }

    public String getAlias() { return this.alias; }

    @Override
    public int hashCode() {
        return alias != null ? alias.hashCode() : 0;
    }
}