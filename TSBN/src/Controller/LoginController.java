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
        if (user_name.equals("") || password.equals("")) {
            return false;
        }
        if(!worker_list.SearchingWorkerBool(user_name)) {
            throw new AlreadyExistException("user" + user_name +"is already exist" );
        }
        // if(!worker_list.SearchingWorkerBool(Integer.parseInt(ID)))
        //     throw new AlreadyExistException("ID" + ID +"is already exist" );
        if(!login_Service.CheckMatch(user_name,password)) {
            throw new AlreadyExistException("no match between password and username" + user_name);
        }
        if(!worker_list.SearchingWorkerBool(user_name)) {
            throw new AlreadyExistException("user" + user_name +"is already exist" );
        }
        String session = login_Service.login(user_name, password);
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }
}





