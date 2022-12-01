package shop.constant;

public enum TypeStatus {
    NEW("Mới"),
    OLD("Cũ");

    public String value;

    TypeStatus(String value) {
        this.value = value;
    }
}