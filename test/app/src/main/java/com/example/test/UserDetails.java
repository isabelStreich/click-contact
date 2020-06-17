package com.example.test;
public class UserDetails
{
    public String ID ;{ get; set; }
    public String Username; { get; set; }
    public String FirstName; { get; set; }
    public String LastName ;{ get; set; }
    public String Address ;{ get; set; }
    public String Country ;{ get; set; }
    public String Email ;{ get; set; }
    public String Password; { get; set; }
    public String Mobile; { get; set; }
    public UserDetails() { }
    public UserDetails(String Id, String username, String fname,String lname,String address,String country, String email, String password, String mobile) //Constructor with all parameters
    {
        ID = Id;
        Username = username;
        FirstName = fname;
        LastName = lname;
        Address = address;
        Country = country;
        Email = email;
        Password = password;
        Mobile = mobile;
    }
    public UserDetails(String Password) //Constructor with one parameter
    {
        this.Password = Password;
    }

}