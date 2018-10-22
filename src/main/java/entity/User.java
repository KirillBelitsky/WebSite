package entity;

import java.util.Date;

public class User {
    private int id;
    private String sex;
    private String firstName;
    private String secondName;
    private String  date;
    private String phone;
    private String password;
    private String email;
    private String passport;
    private String gender;
    private String city;
    private String postIndex;
    private String adress;

    public User(int id,String sex,String firstName,String secondName,String password,
     String phoneNumber,String email,String passport,String city,String index,String adress,String datetime){
        this.id=id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.adress=adress;
        this.sex=sex;
        this.password=password;
        this.passport=passport;
        this.postIndex=index;
        //this.date=datetime;
        this.email=email;
        this.phone=phoneNumber;
        this.adress=adress;
    }
    public User(String sex,String firstName,String secondName,String password,
                String phoneNumber,String email,String passport,String city,String index,String adress,String datetime){
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.adress=adress;
        this.sex=sex;
        this.password=password;
        this.passport=passport;
        this.postIndex=index;
        //this.date=datetime;
        this.email=email;
        this.phone=phoneNumber;
        this.adress=adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
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
}
