package Model;

import java.io.Serializable;

abstract class  Person implements Serializable { // abstract class
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

    public boolean CheckEmail(String mail) { // check if the mail is valid
        int counter=0, i=0;
        if(mail.charAt(i)=='@')
            return false;
        for (i=1;i<mail.length();i++) {
            if (this.getMail().charAt(i) == '@')
                counter++;
            if (counter > 1)
                return false;
        }
        if(counter==1)
            return true;
        return false;
    }
}