package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;


public class LoginController {
    Workers worker_list=Workers.getMySingelton();
    private static LoginController Instance;
    private LoginService login_Service=LoginService.getMySingelton();
    private LoginController() {
    }
    public static LoginController getMySingelton(){
        if(Instance==null)
            Instance=new LoginController();
        return Instance;
    }
    public boolean login(String user_name, String password) throws AlreadyExistException {
        if (user_name.equals("") || password.equals("")) //check if one of the details entered is empty
            throw new AlreadyExistException("Username not exist or Username or password null" );
        if(!worker_list.SearchingWorkerBool(user_name)) //check if exist worker whit the user name that entered in the worker list
            throw new AlreadyExistException("Username not exist or Username or password null" );
        String session = login_Service.login(user_name, password);
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }
}





