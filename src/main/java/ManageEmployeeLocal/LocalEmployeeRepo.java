package ManageEmployeeLocal;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class LocalEmployeeRepo implements EmployeeRepository {
    ArrayList<Employee> EmpRepo = new ArrayList<>();

    LocalEmployeeRepo() {
    }

    LocalEmployeeRepo(ArrayList<Employee> repo) {
        EmpRepo = repo;
    }


    @Override
    public List<Employee> findAll() {
        return EmpRepo;
    }


    @Override
    public Employee save(Employee newEmployee) {

        EmpRepo.stream()
                .filter(x -> x.getId().equals(newEmployee.getId()))
                .findFirst().ifPresent(overwrite -> EmpRepo.remove(overwrite));

        EmpRepo.add(newEmployee);

        int index = EmpRepo.indexOf(newEmployee);
        return EmpRepo.get(index);
    }
}
