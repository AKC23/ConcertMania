package concertmanagementsystem;

public class ConcertInfo {

    private int id;
    private String name;
    private String location;
    private String category;
    private String C_date;
    private int S_id;
    private int M_id;

    public ConcertInfo(int id, String name, String location, String category, String C_date, int S_id, int M_id) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.category = category;
        this.C_date = C_date;
        this.S_id = S_id;
        this.M_id = M_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getC_date() {
        return C_date;
    }

    public int getS_id() {
        return S_id;
    }

    public int getM_id() {
        return M_id;
    }

}
