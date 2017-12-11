import java.util.ArrayList;

public class Customer {

    private String name;
    private String surname;
    private int birthyear;
    private String gender;
    private ArrayList sales;
    private Integer age;

    public Customer() {
    }

    public Customer(String name, String surname, Integer birthyear, String gender) {
        this.name = name;
        this.surname = surname;
        this.birthyear = birthyear;
        this.gender = gender;
        this.sales = new ArrayList();
        this.age = 2017 - birthyear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) throw new IllegalArgumentException("Name is obligatory. Please provide name.");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname == null) throw new IllegalArgumentException("Surname is obligatory. Please provide surname.");
        this.surname = surname;
    }

    public Integer getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(Integer birthyear) {
        if(2017 < birthyear | birthyear < 1900) throw new IllegalArgumentException("Invalid birthyear - value has to be 1900-2017");
        this.birthyear = birthyear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender != "Female" && gender != "Male") throw new IllegalArgumentException("Ony 'Female' or 'Male' is available");
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

}
