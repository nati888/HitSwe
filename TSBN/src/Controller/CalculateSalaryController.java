/*package Controller;

import Model.*;
import java.util.ArrayList;


public class CalculateSalaryController {

    private static CalculateSalaryController Instance;
    private CalculateSalaryController calculate_salary_repository =CalculateSalaryController.getMySingelton();

    private CalculateSalaryController() {
    }

    public static CalculateSalaryController getMySingelton() {
        if (Instance == null)
            Instance = new CalculateSalaryController();
        return Instance;
    }

    public float calculateSalary(String ID){
        if (ID.equals(""))
            return -1;
        String session = calculate_salary_repository.calculateSalary(ID);
        if (session ==-1) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }

}
*/