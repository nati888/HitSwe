package Model;

public class Job {
    private  int Job_ID;
    private  String Job_Name;

    // constructor
    public Job(int Job_ID, String Job_Name) {
        this.Job_ID = Job_ID;
        this.Job_Name = Job_Name;
    }
    int getJob_ID()
    {
        return this.Job_ID;
    }
    String getJob_Name(){
        return this.Job_Name;
    }
    void changeJobName(String new_name)
    {
        this.Job_Name=new_name;
    }
}