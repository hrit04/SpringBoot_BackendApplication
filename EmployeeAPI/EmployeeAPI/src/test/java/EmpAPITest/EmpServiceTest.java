package EmpAPITest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import root.EmpAPI.Emp;
import root.EmpAPI.EmpRepository;
import root.EmpAPI.EmpService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmpServiceTest {

    @InjectMocks
    private EmpService mockService;

    @Mock
    private EmpRepository mockRepository;


    @Test
    public void getAllEmployeesTest()
    {
        List<Emp> list = new ArrayList<Emp>();
        Emp empOne = new Emp("T221", "John", "john@gmail.com", "28", "6000");
        Emp empTwo = new Emp("T223", "Mohn", "Mohn@gmail.com", "38", "7000");
        Emp empThree = new Emp("T228", "Zack", "Zack@gmail.com", "24", "9000");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(mockRepository.findAll()).thenReturn(list);
        //test
        List<Emp> empList = mockService.getAllEmployees();
        assertEquals(3, empList.size());

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    public void getEmployeeTest()
    {
        Emp empOne = new Emp("T221", "John", "john@gmail.com", "28", "6000");


        when(mockRepository.findById("T221")).thenReturn(Optional.of(empOne));
        //test
        Optional<Emp> emp = mockService.getEmployee("T221");

        assertEquals("T221", emp.get().getId());
        assertEquals("John", emp.get().getName());
        assertEquals("john@gmail.com", emp.get().getEmailId());
        assertEquals("28", emp.get().getAge());
        assertEquals("6000",emp.get().getSalary());
       // verify(mockRepository, times(1)).findAll();
    }

    @Test
    public void addEmployeeTest()
    {
        Emp emp = new Emp("T221", "John", "john@gmail.com", "28", "6000");

        mockService.addEmp(emp);

        verify(mockRepository, times(1)).save(emp);
    }

    @Test
    public void deleteEmployeeTest()
    {
        Emp emp = new Emp("T200", "Mohn", "Mohn@gmail.com", "38", "7000");
        mockService.DeleteEmpFromTable(emp.getId());

        verify(mockRepository,times(1)).deleteById(emp.getId());
    }
    @Test
    public void updateEmployeeTest()
    {
        Emp emp = new Emp("T221", "John", "john@gmail.com", "28", "6000");

    }


}
