import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketingManager extends Employee {

    private List<Employee> employees;

    public MarketingManager(String employeeName, long marketingID){
        this(employeeName, null, marketingID);
    }

    public MarketingManager(String employeeName, MarketingManager manager, long marketingID) {
        super(employeeName, manager, marketingID);
        employees = new ArrayList<>();
        if (manager != null) manager.addEmployee(this);
    }

    boolean addEmployee(Employee employee){
        return employees.add(employee);
    }

    List<Employee> getEmployees(){
        return this.employees;
    }

    void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    double bonus(){
        return 250 * employees.size();
    }

    @Override
    public String toString(){
        return employees.stream().map(Employee::getEmployeeName)
                    .collect(Collectors.joining(", ",
                            "Marketing Manager: " + this.employeeName + ". Employees: ", ". Clients: "))
                + getClients().stream().map(x -> Integer.toString(x.getClientID()))
                    .collect(Collectors.joining(", ", "", "\n"))
                + employees.stream().filter(x -> x instanceof MarketingManager)
                    .map(Employee::toString).collect(Collectors.joining("\n", "", ""));
    }

}
