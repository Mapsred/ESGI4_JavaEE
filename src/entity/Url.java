package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Url {
    private int id;
    private String base_url;
    private String new_url;
    private String created_at;
    private String deleted_at;

    public Url() {

    }

    public Url(int id, String base_url, String new_url, String created_at, String deleted_at) {
        this.id = id;
        this.base_url = base_url;
        this.new_url = new_url;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }

    public int getId() {
        return id;
    }

    public String getBaseUrl() {
        return base_url;
    }

    private String getNewUrl() {
        return new_url;
    }
    
    private String getCreatedAt() {
        return created_at;
    }
    
    private String getDeletedAt() {
        return deleted_at;
    }

    public boolean isExpired() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar actual = Calendar.getInstance()    ;
        actual.setTime(new Date());

        Calendar calendar = Calendar.getInstance();
        String date = this.getDeletedAt().split(" ")[0];

        try {
            calendar.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return actual.after(calendar);
    }

    @Override
    public String toString() {
        return "base_url="+this.getBaseUrl()+"/new_url="+this.getNewUrl()+"/created_at="+this.getCreatedAt()+"/deleted_at="+this.getDeletedAt();
    }
}
