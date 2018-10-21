package entity;

import java.util.Date;

public class User {
    private int id;
    private String firstName;
    private String secondName;
    private Date date;
    private int phone;
    private String password;
    private String email;
    private String passport;
    private String gender;
    private String city;
    private String postIndex;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", date=" + date +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", postIndex='" + postIndex + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    private String adress;


    public User(int id,String firstName,String secondName,String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
