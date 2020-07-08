package Model;

import java.io.Serializable;

abstract class  Person implements Serializable {
    private  int ID;
    private  String last_name;
    private  String first_name;
    private String mail;
    // constructor
    public Person(String last_name,String first_name,int ID,String mail) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.ID = ID;
        this.mail=mail;
    }
    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }
    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public int getIDperson(){
        return this.ID;
    }
}