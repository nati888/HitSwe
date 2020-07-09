import Model.*;
import View.SearchingWorkerPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class UpdateWorkerTest  { //Tests after update worker details
    Workers worker_list = Workers.getMySingelton();
    Worker worker1 = new Worker("lalum","tal",313,"tal@a",1,2 ,1,1,"tal1","111");

    @Test
    public void UpdateFirstName(){ //Check if the first name update has been performed
        worker_list.addWorker(worker1);
        Assertions.assertEquals(worker1.getFirst_name(),"tal");
        worker1.setFirst_name("s");
        Assertions.assertEquals(worker1.getFirst_name(),"s");
    }

    @Test
    public void UpdateLastLame(){ //Check if the last name update has been performed
        worker_list.addWorker(worker1);
        Assertions.assertEquals(worker1.getLast_name(),"lalum");
        worker1.setLast_name("sa");
        Assertions.assertEquals(worker1.getLast_name(),"sa");

    }

    @Test
    public void UpdateEmail(){ // Check if the email update has been performed
        worker_list.addWorker(worker1);
        worker1.setMail("t@t");
        Assertions.assertEquals(worker1.getMail(),"t@t");

    }

    @Test
    public void UpdateDepartment(){ // Check if the first name update has been performed
        worker_list.addWorker(worker1);
        worker1.changeJobID(2);
        Assertions.assertEquals(worker1.getJob_ID(),2);
        worker1.changeJobID(3);
        Assertions.assertEquals(worker1.getJob_ID(),3);
    }

    @Test
    public void UpdateJobId(){ // Check if the id of the job update has been performed
        worker_list.addWorker(worker1);
        Assertions.assertEquals(worker1.getJob_ID(),2);
        worker1.changeJobID(50);
        Assertions.assertEquals(worker1.getJob_ID(),50);
    }

    @Test
    public void UpdateSalary(){ // Check if the salary update has been performed
        worker_list.addWorker(worker1);
        worker1.changeSalary(50);
        Assertions.assertEquals(worker1.getBase_Salary(),50);
        worker1.changeSalary(20);
        Assertions.assertEquals(worker1.getBase_Salary(),20);
    }

    @Test
    public void UpdateUsername(){ // Check if the username update has been performed
        worker_list.addWorker(worker1);
        worker1.changeUserName("asa");
        Assertions.assertEquals(worker1.getUser_name(), "asa");
        worker1.changeUserName("zzz");
        Assertions.assertEquals(worker1.getUser_name(), "zzz");
    }

    @Test
    public void UpdatePassword(){// Check if the password update has been performed
        worker_list.addWorker(worker1);
        worker1.changePassword("t50");
        Assertions.assertEquals(worker1.getPassword(),"t50");
    }

}