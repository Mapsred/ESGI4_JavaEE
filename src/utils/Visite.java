package utils;

public class Visite extends Appointment implements Comparable<Visite> {
    private static int nbVisite = 0;
    private String nomEtudiant;
    private String date;
    private int note;

    /**
     * @param nomEtudiant String
     * @param date        String
     * @param note        int
     */
    public Visite(String nomEtudiant, String date, int note, String report) {
        super(report);
        this.nomEtudiant = nomEtudiant;
        this.date = date;
        this.note = note;
        Visite.nbVisite++;
    }

    /**
     * Construct with empty strings
     */
    public Visite() {
        super("");
        this.nomEtudiant = "";
        this.date = "";
        Visite.nbVisite++;
    }



    /**
     * @return String
     */
    public String getNomEtudiant() {
        return nomEtudiant;
    }

    /**
     * @param nomEtudiant String
     * @return Visite
     */
    public Visite setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
        return this;
    }

    /**
     * @return int
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date String
     * @return Visite
     */
    public Visite setDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * @return int
     */
    public int getNote() {
        return note;
    }

    /**
     * @param note int
     * @return Visite
     */
    public Visite setNote(int note) {
        this.note = note;
        return this;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return this.getNomEtudiant() + " - " + this.getDate();
    }

    /**
     *
     * @param visite Visite
     * @return int
     */
    @Override
    public int compareTo(Visite visite) {
        return visite.nomEtudiant.equals(this.nomEtudiant) ? 1 : 0;
    }

    @Override
    public void printReport() {
        System.out.print(Visite.nbVisite + " : ");
        super.printReport();
    }
}
