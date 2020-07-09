package Controller;

import Model.*;

import java.io.IOException;
import java.util.ArrayList;


public class DeleteWorkerController {

    private static DeleteWorkerController Instance;
    private DeleteWorkerRepository delete_worker_repository =DeleteWorkerRepository.getMySingelton(); // initialize delete worker repository object

    private DeleteWorkerController() {
    }

    public static DeleteWorkerController getMySingelton() { //create singelton
        if (Instance == null)
            Instance = new DeleteWorkerController();
        return Instance;
    }

    public boolean delete(String ID) throws IOException {
        if (ID.trim().equals("")) //check if the required id is empty
            return false;
        String session = delete_worker_repository.deleteWorker(ID); // call to repository object
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }

}
