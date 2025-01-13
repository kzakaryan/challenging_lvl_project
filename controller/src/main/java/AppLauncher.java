import java.util.Scanner;

public class AppLauncher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseControllerImpl.launch(scanner);
    }
}
