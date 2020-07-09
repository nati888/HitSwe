import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CalculateSalaryTest { //Calculate salary tests

    @Test
    public void CheckCalculateSalary(){ // test for the calculating salary after change the base salary per hour and the amount of work hours
        Worker worker1 = new Worker("lalum3","tal",313,"tal@",1,1 ,1,50,"tal3","111");
        worker1.setHours(100);
        Assertions.assertEquals(worker1.calculateSalary(),5000);
        worker1.setHours(2);
        worker1.changeSalary(20);
        Assertions.assertEquals(worker1.calculateSalary(),40);
        worker1.setHours(250);
        worker1.changeSalary(130);
        Assertions.assertEquals(worker1.calculateSalary(),32500);
        worker1.setHours(200);
        worker1.changeSalary(100);
        Assertions.assertEquals(worker1.calculateSalary(),20000);
        CalculateSalaryRepository calculateSalaryRepository = CalculateSalaryRepository.getMySingelton();
    }
}