package Model;

import java.security.PublicKey;
import java.util.ArrayList;

public class Ex_Worker extends Person {

    private int num_Worker;
    private int department_ID;
    private double experience;
    private int job_ID;


    public Ex_Worker(String last_name, String first_name, int ID, String mail, int num_Worker, int department_id, double experience, int Job_ID) {
        super(last_name, first_name, ID, mail);
        this.num_Worker = num_Worker;
        this.department_ID = department_id;
        this.job_ID = Job_ID;
        this.experience = experience;
    }

    public int getNum_Worker() {
        return num_Worker;
    }

    public int getDepartment_ID() {
        return department_ID;
    }

    public double getExperience() {
        return experience;
    }

    public int getJob_ID() {
        return job_ID;
    }
}