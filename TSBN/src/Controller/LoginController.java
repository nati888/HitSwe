package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;


public class LoginController {
    Workers worker_list=Workers.getMySingelton();
    private static LoginController Instance;
    private LoginRepository login_Repository=LoginRepository.getMySingelton();
    private LoginController() {
    }
    public static LoginController getMySingelton(){
        if(Instance==null)
            Instance=new LoginController();
        return Instance;
    }
    public boolean login(String user_name, String password) throws AlreadyExistException {
        if (user_name.trim().equals("") || user_name == null || password.trim().equals("") || password==null ) //check if one of the details entered is empty
            return false;
        String session = login_Repository.validateUser(user_name, password);
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }
}





