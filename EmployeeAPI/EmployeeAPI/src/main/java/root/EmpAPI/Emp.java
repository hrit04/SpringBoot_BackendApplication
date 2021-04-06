package root.EmpAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Emp {
    @Id
    @GeneratedValue
    private String Id;
    private String name;
    private String emailId;

    private String  age;
    private String salary;

    public Emp() {
    }

    public Emp(String Id,String name,String emailId,String age,String salary) {
        super();
        this.Id=Id;
        this.name=name;
        this.emailId=emailId;
        this.age = age;
        this.salary=salary;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return Id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
