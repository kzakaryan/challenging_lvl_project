import java.text.ParseException;
import java.util.Scanner;

public class AppLauncher {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        DatabaseControllerImpl.launch(scanner);
    }
}
