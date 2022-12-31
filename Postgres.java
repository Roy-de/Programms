import java.sql.Connection;
import java.sql.DriverManager;

public class Postgres{
    void connect(){
     Connection c = null;
     try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","7934");
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }
    }

    public static void main(String[] args){
        Postgres test = new Postgres();
        test.connect();
    }
}