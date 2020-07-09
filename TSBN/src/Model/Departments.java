package Model;

import java.io.IOException;
import java.util.ArrayList;

public class Departments {
    private static Departments Instance = new Departments();
    private static ArrayList<Department> departments_list= new ArrayList<Department>(); // create a list of department

    private Departments() {
    }

    public static Departments getMySingelton() { // create singelton and initialize it
        if(departments_list.size()==0){
            Department department1=new Department(1,"Name_1");
            Department department2=new Department(2,"Name_2");
            Department department3=new Department(3,"Name_3");
            Department department4=new Department(4,"Name_4");
            Department department5=new Department(5,"Name_5");
            departments_list.add(department1);
            departments_list.add(department2);
            departments_list.add(department3);
            departments_list.add(department4);
            departments_list.add(department5);
        }
        return Instance;
    }

    public void addDepartment(Department new_department) { // add a new department to the list
        departments_list.add(new_department);
    }

    public void removeDepartment(Department remove_department) throws IOException { // remove department from the list
        departments_list.remove(remove_department);

    }
    public Department searchingDepartmentById(int ID) { // search department in the list based on id
        for (int i = 0; i < this.departments_list.size(); i++)
            if (departments_list.get(i).getID() == ID)
                return departments_list.get(i); // return data
        return null; // return null if there is no exist a department with the required id
    }

    public Boolean SearchingDepartmentBool(int ID) { // check if there is exist department in the list based on id
        Departments departments_list = Departments.getMySingelton();
        for (int i = 0; i < departments_list.getSize(); i++)
            if (departments_list.getDepartment_i(i).getID() == ID)
                return true;
        return false;
    }
    public int getSize() {
        return departments_list.size();
    } // get the size of the list

    public Department getDepartment_i(int i) {
        return departments_list.get(i);
    } // get department in index i

    public void setJob_List_i(int i, Department new_department) {
        departments_list.set(i, new_department);
    } // set another department in index i


}
