package Model;

public class WorkerBuilder {
    private String last_name;
    private String first_name;
    private int id;
    private String mail;
    private int department_id;
    private double hours;
    private int job_id;
    private float experience;
    private float base_salary;
    private String user_name;
    private String password;

    public WorkerBuilder Last_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public WorkerBuilder First_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public WorkerBuilder ID(int id) {
        this.id = id;
        return this;
    }

    public WorkerBuilder Mail(String mail) {
            this.mail = mail;
        return this;
    }

    public WorkerBuilder Department_id(int department_id) {
        this.department_id = department_id;
        return this;
    }

    public WorkerBuilder Job_ID(int job_id) {
        this.job_id = job_id;
        return this;
    }

    public WorkerBuilder Experience(float experience) {
        this.experience = experience;
        return this;
    }

    public WorkerBuilder Base_salary(float base_salary) {
        this.base_salary = base_salary;
        return this;
    }

    public WorkerBuilder User_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public WorkerBuilder Password(String password) {
        this.password = password;
        return this;
    }

    public Worker createWorker() {
        return new Worker(last_name, first_name, id, mail, department_id, job_id, experience, base_salary, user_name, password);
    }
}