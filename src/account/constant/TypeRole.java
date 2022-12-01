package account.constant;

public enum TypeRole {
    A("admin"),
    C("customer"),
    SF("staff"),
    T("teacher"),
    S("student");


    public String value;

    TypeRole(String value) {
        this.value = value;
    }


}
