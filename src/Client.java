import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    private int clientID;
    private String clientName;
    private List<Employee> employeeList;

    public Client(int clientID, String clientName) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.employeeList = new ArrayList<>();
    }

    boolean addEmployee(Employee employee){
       return employeeList.add(employee);
    }

    boolean addEmployees(Employee... employees){
        return Arrays.stream(employees).map(x -> {
            x.addClient(this);
            return employeeList.add(x);
        }).allMatch(x -> true);
    }

    public double totalSales(){
        return 0;
    }

    int getClientID(){
        return this.clientID;
    }

    void setClientID(int clientID){
        this.clientID = clientID;
    }

    String getClientName() {
        return clientName;
    }

    void setClientName(String clientName) {
        this.clientName = clientName;
    }

    List<Employee> getEmployeeList() {
        return employeeList;
    }

    void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString(){
        return "ClientID: " + this.clientID +
                employeeList.stream().map(Employee::getEmployeeName)
                        .collect(Collectors.joining(", ", ". Marketing Employee: ", "."));
    }

}
