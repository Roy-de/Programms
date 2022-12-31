import java.io.InputStream;
import org.ini4j.Wini;

public class name{
    private static final String SAMPLE_INI_FILE = "config.ini";
    public static void main(String[] args) throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(SAMPLE_INI_FILE);
        Wini ini = new Wini(inputStream);
        String name = ini.get("Author", "name", String.class);
        String updateDate = ini.get("Author", "updateDate", String.class);
        System.out.println("name=" + name);
        System.out.println("updateDate=" + updateDate);
        String server = ini.get("database", "server", String.class);
        Integer port = ini.get("database", "port", Integer.class);
        String username = ini.get("database", "username", String.class);
        
        System.out.println("server= " + server);
        System.out.println("port = " + port);
        System.out.println("username = " + username);
    }
}