package Controller;

import Model.Worker;

public class SortingWorkerName implements  WorkerComparator {
    @Override
    public int compare(Worker worker1, Worker worker2) {
        return worker1.getLast_name().compareTo(worker2.getLast_name());
    }
}
