import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Employee {

    private List<Client> clientList;
    protected String employeeName;
    protected MarketingManager marketingManager;
    protected long marketingID;

    public Employee(String employeeName, MarketingManager manager, long marketingID) {
        this.employeeName = employeeName;
        this.marketingManager = manager;
        this.marketingID = marketingID;
        this.clientList = new ArrayList<>();
    }

    public List<Client> getClients() {
        return this.clientList;
    }

    void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public boolean addClient(Client... clients) {
        return Arrays.stream(clients).map(x -> {
            x.addEmployee(this);
            return clientList.add(x);
        }).allMatch(x -> true);
    }

    String getEmployeeName() {
        return employeeName;
    }

    void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    MarketingManager getMarketingManager() {
        return marketingManager;
    }

    void setMarketingManager(MarketingManager marketingManager) {
        marketingManager.addEmployee(this);
        this.marketingManager = marketingManager;
    }

    long getMarketingID() {
        return marketingID;
    }

    void setMarketingID(long marketingID) {
        this.marketingID = marketingID;
    }

    @Override
    public String toString(){
        return this.employeeName;
    }

}
