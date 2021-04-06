package root.EmpAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/employees")
    public List<Emp> getAllEmployees()
    {
        return empService.getAllEmployees();
    }
    @RequestMapping("/employees/{Id}")
    public Optional<Emp> getEmployee(@PathVariable String Id)
    {
        return empService.getEmployee(Id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/employees")
    public void addEmp(@RequestBody Emp emp )
    {
        empService.addEmp(emp);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/employees/{Id}")
    public void updateEmpDetails(@RequestBody Emp emp,@PathVariable String Id )
    {

        empService.updateEmpDetails(Id,emp);

    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/employees/{Id}")
    public void deleteEmpFromTable(@PathVariable String Id)
    {
        empService.DeleteEmpFromTable(Id);

    }



}
