package entity;

public class UrlPassOption {

    private int id;
    private String libelle;
    private String end_date;

    public UrlPassOption(int id, String libelle, String end_date) {
        this.id = id;
        this.libelle = libelle;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public String getSimpleId() {
        return libelle;
    }

    public String getEndDate() {
        return end_date;
    }
}
