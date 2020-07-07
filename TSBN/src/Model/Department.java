package Model;

import Model.Worker;

import java.util.ArrayList;

public class Department {
    private int ID;
    private  String Name;

    public Department(int id, String name) {
        this.ID = id;
        this.Name = name;
    }

    int getID(){ return ID;}
    String getName(){return Name;}
    void changeDepartmentName(String new_name){Name=new_name;}

}
