import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class DeleteWorkerTest  {

    @Test
    public void CheckSizeOfListAfterRemoveWorker() throws IOException {
        Workers worker_list = Workers.getMySingelton();
        Worker worker1 = new WorkerBuilder().createWorker();
        worker_list.addWorker(worker1);
        Assertions.assertEquals(1, worker_list.getSize());
        worker_list.removeWorker(worker1);
        Assertions.assertEquals(0, worker_list.getSize());
    }

    @Test
    public void searchingWorkerAfterRemoveHimFromTheList() throws IOException {
        Workers worker_list = Workers.getMySingelton();
        Worker worker1 = new Worker("lalum","tal",313,"tal@",1,1 ,1,1,"tal1","111");
        Worker worker2 = new Worker("lalum2","tal",313,"tal@",1,1 ,1,1,"tal2","111");
        worker_list.addWorker(worker1);
        worker_list.addWorker(worker2);
        worker_list.removeWorker(worker1);
        Assertions.assertFalse(worker_list.SearchingWorkerBool("tal1"));
        worker_list.removeWorker(worker2);
        Assertions.assertFalse(worker_list.SearchingWorkerBool("tal1"));
    }
}
