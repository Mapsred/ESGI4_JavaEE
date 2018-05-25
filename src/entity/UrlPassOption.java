package entity;

public class UrlPassOption {

    private int id;
    private String libelle;
    private String end_date;
    private String start_date;
    private int max_click;

    public UrlPassOption(int id, String libelle, String end_date, String start_date, int max_click) {
        this.id = id;
        this.libelle = libelle;
        this.end_date = end_date;
        this.start_date = start_date;
        this.max_click = max_click;
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

    public String getStartDate() {
        return start_date;
    }

    public int getMaxClick() {
        return max_click;
    }
}
