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

    /// Các môn học sẽ là dữ liệu có sẵn nên ko cần inputInfo phải không?
}
