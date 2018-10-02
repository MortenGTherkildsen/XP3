package dk.mth.test.demo.model;

import javax.validation.constraints.NotEmpty;

public class Person {


    private String name = "";
    private String birthdate = "";

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    public Person(String name, String birthdate, String email, String password) {
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}