public class MarketingAssociate extends Employee{

    public MarketingAssociate(String employeeName, MarketingManager manager, long marketingID) {
        super(employeeName, manager, marketingID);
        manager.addEmployee(this);
    }

    double bonus(){
        return 500 * super.getClients().size();
    }

    @Override
    public String toString(){
        return "Employee: " + super.employeeName + ". Marketing Manager: " +
                ((super.marketingManager != null) ? super.marketingManager.employeeName : "None") + ".";
    }
}
