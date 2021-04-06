package root.EmpAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;


    public List<Emp> getAllEmployees() {
        List <Emp> emp=new ArrayList<>();
        empRepository.findAll().forEach(emp::add);
        return emp;

    }

    public Optional<Emp> getEmployee(String Id) {
        //  return topics.stream().filter(topics -> topics.getId().equals(id)).findFirst().get();

        return  empRepository.findById(Id) ;
    }

    public void addEmp(Emp emp) {
        empRepository.save(emp);
    }


    public void updateEmpDetails(String Id, Emp emp) {
        empRepository.save(emp);
    }

    public void DeleteEmpFromTable(String Id) {

        empRepository.deleteById(Id);
    }
}
