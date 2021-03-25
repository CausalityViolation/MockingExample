package ManageEmployeeLocal;

import com.example.Employee;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LocalEmployeeRepoTest {

    LocalEmployeeRepo testRepo = new LocalEmployeeRepo();

    @Test
    void findAllTest() {


        var listOfEmp = testRepo.findAll();
        assertEquals(0,listOfEmp.size());

    }

    @Test
    void AddSomeThenFindAllTest() {

        testRepo.save(new Employee("first",1));
        testRepo.save(new Employee("second",2));

        var listOfEmp = testRepo.findAll();
        assertEquals(2,listOfEmp.size());

    }

    @Test
    void IfDuplicateIDOverwriteSaveTest(){

        testRepo.save(new Employee("first",1));
        testRepo.save(new Employee("second",2));
        testRepo.save(new Employee("first",500));

        var listOfEmp = testRepo.findAll();
        assertEquals(2, listOfEmp.size());

    }



}