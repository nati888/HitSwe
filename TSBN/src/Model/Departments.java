package Model;

import java.io.IOException;
import java.util.ArrayList;

public class Departments {
    private static Departments Instance = new Departments();
    private static ArrayList<Department> departments_list= new ArrayList<Department>();

    private Departments() {
        Department department1=new Department(1,"Name_1");
        Department department2=new Department(1,"Name_2");
        Department department3=new Department(1,"Name_3");
        Department department4=new Department(1,"Name_4");
        Department department5=new Department(1,"Name_5");
        departments_list.add(department1);
        departments_list.add(department2);
        departments_list.add(department3);
        departments_list.add(department4);
        departments_list.add(department5);

    }

    public static Departments getMySingelton() {
        return Instance;
    }

    public void addDepartment(Department new_department) {
        departments_list.add(new_department);
    }

    public void removeDepartment(Department remove_department) throws IOException {
        departments_list.remove(remove_department);

    }
    public Department searchingDepartmentById(int ID) {
        for (int i = 0; i < this.departments_list.size(); i++)
            if (departments_list.get(i).getID() == ID)
                return departments_list.get(i);
        return null;
    }

    public Boolean SearchingDepartmentBool(int ID) {
        Workers worker_list = Workers.getMySingelton();
        for (int i = 0; i < worker_list.getSize(); i++)
            if (departments_list.get(i).getID() == ID)
                return true;
        return false;
    }
    public int getSize() {
        return departments_list.size();
    }

    public Department getDepartment_i(int i) {
        return departments_list.get(i);
    }

    public void setJob_List_i(int i, Department new_department) {
        departments_list.set(i, new_department);
    }


}
