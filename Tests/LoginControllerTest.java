import Controller.Exception1.AlreadyExistException;
import Controller.LoginController;
import Model.Worker;
import Model.Workers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginControllerTest {

    LoginController loginController = LoginController.getMySingelton();

    @Test
    public void loginFailedWhenUserIsEmpty() { //test for login failed when username is empty
        try {
            loginController.login("  ", "111");
            Assertions.fail("Login success but should failed");
        } catch (AlreadyExistException e) {
            Assertions.assertEquals("Username not exist or Username or password null", e.getMessage());
        }
    }

    @Test
    public void loginFailedWhenUserAndPasswordIsEmpty() { //test for login failed when password and username is empty
        try {
            loginController.login("  ", "  ");
            Assertions.fail("Login success but should failed");
        } catch (AlreadyExistException e) {
            Assertions.assertEquals("Username not exist or Username or password null", e.getMessage());
        }
    }

    @Test
    public void CheckMatch() throws AlreadyExistException { //Test if user name and password match
        Workers worker_list= Workers.getMySingelton();
        Worker worker1 = new Worker("lalum","tal",313,"tal@",1,1 ,1,1,"tal","111");
        worker_list.addWorker(worker1);
        Assertions.assertTrue(loginController.login("tal","111"));
        Assertions.assertFalse(loginController.login("tal","123"));
    }
}
