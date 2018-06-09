package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public String getLibelle() {
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

    public boolean isEnabled() {
        if (null == this.getStartDate() && null == this.getEndDate()) {
            return true;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar actual = Calendar.getInstance();
        actual.setTime(new Date());

        Calendar start_date = Calendar.getInstance();
        String start_date_string = this.getStartDate().split(" ")[0];
        try {
            start_date.setTime(format.parse(start_date_string));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (null == this.getEndDate()) {
            return actual.after(start_date);
        }

        Calendar end_date = Calendar.getInstance();
        String end_date_string = this.getEndDate().split(" ")[0];
        try {
            end_date.setTime(format.parse(end_date_string));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return actual.after(start_date) && actual.before(end_date);
    }

    public boolean isMaxClick(int clickNb) {
        return clickNb < this.getMaxClick();
    }

}
