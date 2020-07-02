package Controller;

import Controller.WorkerComparator;
import Model.Worker;

public class SortingWorkerSalary implements WorkerComparator {
    @Override
    public int compare(Worker worker1, Worker worker2) {
        return (int)(worker1.getBase_Salary()-worker2.getBase_Salary());
    }
}
