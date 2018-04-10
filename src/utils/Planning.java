package utils;


import java.util.ArrayList;

public class Planning {
    private String nomProf;
    private ArrayList<Visite> visites;

    /**
     * @return String
     */
    public String getNomProf() {
        return nomProf;
    }

    /**
     * @param nomProf String
     * @return Planning
     */
    public Planning setNomProf(String nomProf) {
        this.nomProf = nomProf;

        return this;
    }

    /**
     * @return ArrayList<Visite>
     */
    public ArrayList<Visite> getVisites() {
        return visites;
    }

    /**
     * @param visites ArrayList<Visite>
     * @return Planning
     */
    public Planning setVisites(ArrayList<Visite> visites) {
        this.visites = visites;

        return this;
    }

    /**
     * @param visite Visite
     * @return Planning
     */
    public Planning addVisite(Visite visite) {
        this.visites.add(visite);

        return this;
    }

    /**
     * @param visite Visite
     * @return Planning
     */
    public Planning removeVisite(Visite visite) {
        this.visites.remove(visite);

        return this;
    }

    /**
     * @param nomEtudiant String
     * @return Planning
     */
    public Planning removeVisite(String nomEtudiant) {
        for (Visite visite : this.visites) {
            if (visite.getNomEtudiant().equals(nomEtudiant)) {
                this.removeVisite(visite);
            }
        }

        return this;
    }

    @Override
    public String toString() {
        return this.getNomProf();
    }
}

