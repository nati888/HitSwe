package Model;

import java.security.PublicKey;
import java.util.ArrayList;

public class Worker extends Person {
    int NUM_WORKER = 1;

    private int num_Worker;
    private int department_ID;
    private double experience;
    private double base_Salary;
    private double hours;
    private ArrayList<String> assessment;
    private String user_name;
    private String password;
    private int job_ID;
  
      public Worker(String last_name, String first_name, int ID, String mail,int department_id, int Job_ID, float experience, float base_salary,String user_name, String password) {
        super(last_name, first_name,ID,mail);
        this.num_Worker = NUM_WORKER++;
        this.department_ID = department_id;
        this.job_ID = Job_ID;
        this.experience = experience;
        this.base_Salary = base_salary;
        this.hours = 100;
        this.assessment = new ArrayList<String>();
        this.user_name=user_name;
        this.password = password;
    }

    public int getNum_Worker() { return num_Worker; }
    public int getDepartment_ID() { return department_ID; }
    public double getExperience() { return experience; }
    public double getBase_Salary() { return base_Salary; }
    public double getHours() { return hours; }
    public ArrayList<String> getAssessment() { return assessment; }
    public String getPassword() { return password; }
    public String getUser_name(){ return user_name;}
    public int getJob_ID() { return job_ID; }
    public void setHours(float hours) { this.hours = hours; }
    public void changeJobID(int new_ID){
        this.job_ID=new_ID;
    }
    public void changeExperience(float new_experience){
        this.experience=new_experience;
    }
    public void changeDepartmentID(int new_department){
        this.department_ID=new_department;
    }
    public void changeSalary(float new_salary){
        this.base_Salary=new_salary;
    }
    public double calculateSalary(){
        return base_Salary*hours;
    }
    public void changeUserName(String user_name_new) {
        this.user_name = user_name_new;
    }
    public void changePassword(String new_pass) {
        this.password=new_pass;
    }

    public boolean checkID(String id) {// check if the id is valid, 9 numbers
        if(id.length() == 9)
            return true;
        return false;
    }
}

