package Controller;
import java.util.ArrayList;

public class LoginController {
        private static LoginController Instance;
        private LoginService login_Service=LoginService.getMySingelton();
        private LoginController() {
        }

        public static LoginController getMySingelton(){
            if(Instance==null)
                Instance=new LoginController();
            return Instance;
        }
        public boolean login(String user_name, String password) {
            if (user_name.equals("") || password.equals("")) {
                return false;
            }
            String session = login_Service.login(user_name, password);
            if (session != null) {
                System.out.println("Session token: " + session);
                return true;
            }
            return false;
        }
    }




}
