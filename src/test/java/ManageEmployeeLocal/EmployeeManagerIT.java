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
    EmployeeManager manager = new EmployeeManager(new LocalEmployeeRepo(List.of(

            new Employee("one", 500),
            new Employee("two", 1000),
            new Employee("three", 1500),
            new Employee("four", 2000))), mockBank);

    @Test
    void checkPaidEmployeesAndRepoTest() {

        assertEquals(4, manager.payEmployees());
    }

    @Test
    void runtimeExceptionTest() {

        doThrow(new RuntimeException()).when(mockBank).pay("four", 2000);
        assertEquals(3, manager.payEmployees());
    }

}
