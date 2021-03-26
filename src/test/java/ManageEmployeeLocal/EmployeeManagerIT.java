package ManageEmployeeLocal;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class EmployeeManagerIT {


    BankService mockBank = mock(BankService.class);

    LocalEmployeeRepo repo = new LocalEmployeeRepo((List.of(
            new Employee("one", 500),
            new Employee("two", 1000),
            new Employee("three", 1500),
            new Employee("four", 2000))));

    EmployeeManager manage = new EmployeeManager(repo,mockBank);



    @Test
    void checkPaidEmployeesAndRepoTest() {

        assertEquals(4, manage.payEmployees());
    }

    @Test
    void runtimeExceptionVerifyIsPaidTest() {

        doThrow(new RuntimeException()).when(mockBank).pay("four", 2000);
        assertEquals(3, manage.payEmployees());
        Employee one = repo.findAll().get(0);
        Employee four = repo.findAll().get(3);

        assertTrue(one.isPaid());
        assertFalse(four.isPaid());

    }

}
