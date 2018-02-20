/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

/**
 *
 * @author ss
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private int phoneNumber;
    private String gender;
    private String image;
    private int role;
    private int age;
    private String address;
    private String date_SU;
    private int nbr_like;
    private Wishlist wishliste;
    private Command command;
/*
    #########~~Mohamed's VARIABLE~~#################"
   
    */
       public static final int MAX = 20;

    public Wishlist getWishliste() {
        return wishliste;
    }

    public void setWishliste(Wishlist wishliste) {
        this.wishliste = wishliste;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_SU() {
        return date_SU;
    }

    public void setDate_SU(String date_SU) {
        this.date_SU = date_SU;
    }

    public int getNbr_like() {
        return nbr_like;
    }

    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    public User(String fname, String lname, String email, String password, int role, String username, int phoneNumber, String gender, String image, int age, String address, String date_SU, int like, int id) {

        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.image = image;

        this.age = age;
        this.address = address;
        this.date_SU = date_SU;
        this.nbr_like = like;
        this.id = id;
    }
      public User(String fname, String lname, String email, String password, int role, String username, int phoneNumber, String gender, String image, int age, String address, String date_SU, int like) {

        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.image = image;

        this.age = age;
        this.address = address;
        this.date_SU = date_SU;
        this.nbr_like = like;
      
    }

    public User() {
    }
    public User(String email)
    {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", image=" + image + ", role=" + role + ", age=" + age + ", address=" + address + ", date_SU=" + date_SU + ", nbr_like=" + nbr_like + '}';
    }

}
