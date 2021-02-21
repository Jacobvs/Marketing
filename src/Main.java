public class Main {

    public static void main(String[] args) {
        // Clients
        Client three = new Client(3, "Ed");
        Client nine = new Client(9, "Jacob");
        Client fourtytwo = new Client(42, "Mayaaaak");

        // Managers
        MarketingManager John = new MarketingManager("John", 0);
        MarketingManager Mary = new MarketingManager("Mary", John, 1);

        // Associates
        MarketingAssociate Peter = new MarketingAssociate("Peter", John, 2);
        MarketingAssociate Jim = new MarketingAssociate("Jim", Mary, 3);
        MarketingAssociate Janet = new MarketingAssociate("Janet", Mary,4);

        Mary.addClient(three, fourtytwo);
        John.addClient(nine);

        //Managers References
        System.out.println(John);

        //Associates References
        System.out.println(Peter);
        System.out.println(Jim);
        System.out.println(Janet);

        //Clients References
        System.out.println(three);
        System.out.println(nine);
        System.out.println(fourtytwo);

    }
}
