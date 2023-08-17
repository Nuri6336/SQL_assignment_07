package campus_reqruit;

public class Main {
    public static void main(String[] args) {
        DBConnections objectOfDB = new DBConnections();
        objectOfDB.connectDB();
        System.out.println("");
        objectOfDB.fetchingDBData();
        System.out.println("");
        objectOfDB.countByInterest();
        System.out.println("");
        objectOfDB.innerJoinEx();
    }
}