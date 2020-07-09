package Model;
import java.util.ArrayList;
import java.util.UUID;


public class LoginRepository {

    private static LoginRepository Instance;

    private LoginRepository() {
    }

    public static LoginRepository getMySingelton() { // create the singeltone
        if (Instance == null)
            Instance = new LoginRepository();
        return Instance;
    }
    public String validateUser(String user_name,String password){
        File.fileRead(); // get the exist workers
        File_Ex.fileRead();
        Workers worker_list=Workers.getMySingelton();
        for (int i = 0; i < worker_list.getSize(); i++) // check if there is a worker that have the required user name and password
            if (worker_list.getWorker_i(i).getUser_name().equals(user_name) && worker_list.getWorker_i(i).getPassword().equals(password))
                return UUID.randomUUID().toString();;
        return null;
    }
}

