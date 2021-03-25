package ManageEmployeeLocal;

import com.example.Employee;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocalEmployeeRepoTest {

    LocalEmployeeRepo testRepo = new LocalEmployeeRepo();

    @Test
    void findAllTest() {


        var listOfEmp = testRepo.findAll();
        assertEquals(0, listOfEmp.size());

    }

    @Test
    void AddSomeThenFindAllTest() {

        testRepo.save(new Employee("first", 1));
        testRepo.save(new Employee("second", 2));

        var listOfEmp = testRepo.findAll();
        assertEquals(2, listOfEmp.size());

    }

    @Test
    void IfDuplicateIDOverwriteSaveTest() {

        testRepo.save(new Employee("first", 1));
        testRepo.save(new Employee("second", 2));
        testRepo.save(new Employee("first", 500));

        var listOfEmp = testRepo.findAll();
        assertEquals(2, listOfEmp.size());

    }

    @Test
    void ListConstructorTest() {

        Employee e1 = new Employee("one", 1);
        Employee e2 = new Employee("two", 2);

        LocalEmployeeRepo testList = new LocalEmployeeRepo(List.of(e1, e2));
        var listOfEmp = testList.findAll();
        assertEquals(3, listOfEmp.size());

        assertTrue(testList.findAll().contains(e1));
        assertTrue(testList.findAll().contains(e2));


    }


}