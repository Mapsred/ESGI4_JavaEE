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
    private String updated_at;

    public Url() {

    }

    public Url(int id, String base_url, String new_url, String created_at, String updated_at) {
        this.id = id;
        this.base_url = base_url;
        this.new_url = new_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
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
    
    private String getUpdatedAt() {
        return updated_at;
    }

    public boolean isExpired() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar actual = Calendar.getInstance()    ;
        actual.setTime(new Date());

        Calendar calendar = Calendar.getInstance();
        String date = this.getCreatedAt().split(" ")[0];

        try {
            calendar.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return actual.after(calendar);
    }

    @Override
    public String toString() {
        return "base_url="+this.getBaseUrl()+"/new_url="+this.getNewUrl()+"/created_at="+this.getCreatedAt()+"/updated_at="+this.getUpdatedAt();
    }
}
