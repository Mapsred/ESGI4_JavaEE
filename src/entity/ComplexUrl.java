package entity;

public class ComplexUrl {

    private int id;
    private int simple_id;
    private int user_id;

    public ComplexUrl(int id, int simple_id, int user_id) {
        this.id = id;
        this.simple_id = simple_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public int getSimpleId() {
        return simple_id;
    }

    public int getUserId() {
        return user_id;
    }
}
