import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AddWorkerTest {

    @Test
    public void CheckSizeOfListAfterAddWorker(){
        Workers worker_list = Workers.getMySingelton();
        int BaseSize=worker_list.getSize();
        Worker worker1 = new WorkerBuilder().createWorker();
        worker_list.addWorker(worker1);
        Assertions.assertEquals(BaseSize+1, worker_list.getSize());
        Worker worker2 = new WorkerBuilder().createWorker();
        worker_list.addWorker(worker2);
        Assertions.assertEquals(BaseSize+2, worker_list.getSize());
    }

    @Test
    public void searchingWorkerAfterAddHimToTheList(){
        Workers worker_list = Workers.getMySingelton();
        Worker worker1 = new Worker("lalum","tal",313,"tal@",1,1 ,1,1,"tal1","111");
        Worker worker2 = new Worker("lalum2","tal",3132,"tal@",1,1 ,1,1,"tal2","111");
        worker_list.addWorker(worker1);
        Assertions.assertTrue (worker_list.SearchingWorkerBool("tal1"));
        worker_list.addWorker(worker2);
        Assertions.assertTrue (worker_list.SearchingWorkerBool("tal2"));
        Assertions.assertFalse (worker_list.SearchingWorkerBool("tal3"));
        Assertions.assertTrue(worker_list.SearchingWorkerBool( 313));
        Assertions.assertTrue(worker_list.SearchingWorkerBool( 3132));
    }
}
