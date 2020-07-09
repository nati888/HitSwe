import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class DeleteWorkerTest  { //tests about after remove worker of the workers list

    @Test
    public void CheckSizeOfListAfterRemoveWorker() throws IOException { // Check if the size of the workers list decreases after deleting worker
        Workers worker_list = Workers.getMySingelton();
        Worker worker1 = new WorkerBuilder().createWorker();
        int BaseSize=worker_list.getSize();
        worker_list.addWorker(worker1);
        Assertions.assertEquals(BaseSize, worker_list.getSize());
        worker_list.removeWorker(worker1);
        Assertions.assertEquals(BaseSize-1, worker_list.getSize());
    }

    @Test
    public void searchingWorkerAfterRemoveHimFromTheList() throws IOException { // Check that worker not exist in workers list after deleting worker
        Workers worker_list = Workers.getMySingelton();
        Worker worker1 = new Worker("lalum","tal",313,"tal@",1,1 ,1,1,"tal1","111");
        Worker worker2 = new Worker("lalum2","tal",3132,"tal@",1,1 ,1,1,"tal2","111");
        worker_list.addWorker(worker1);
        worker_list.addWorker(worker2);
        worker_list.removeWorker(worker1);
       Assertions.assertFalse(worker_list.SearchingWorkerBool("tal1"));
        worker_list.removeWorker(worker2);
        Assertions.assertFalse(worker_list.SearchingWorkerBool("tal1"));
        Assertions.assertFalse(worker_list.SearchingWorkerBool( 313));
        Assertions.assertFalse(worker_list.SearchingWorkerBool( 3132));

    }
}
