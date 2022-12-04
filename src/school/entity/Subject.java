package school.entity;

public class Subject {
    private static int autoID = 1;
    private int id;
    private String name;
    private int numberOfCredits;
    private String type;

    public Subject() {
        id = autoID++;
    }

    public static int getAutoID() {
        return autoID;
    }

    public static void setAutoID(int autoID) {
        Subject.autoID = autoID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /// Các môn học sẽ là dữ liệu có sẵn nên ko cần inputInfo phải không?

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                ", type='" + type + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.printf("%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\n", this.id, this.name, this.numberOfCredits, this.type);
    }


    public Subject(String name, int numberOfCredits, String type) {
        id = autoID++;
        this.name = name;
        this.numberOfCredits = numberOfCredits;
        this.type = type;
    }
}
