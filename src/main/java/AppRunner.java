import ui.UI;

public class AppRunner {

    public static void main(String[] args) {
        int memberId = Integer.parseInt(args[0]);
        UI ui = new UI(System.out);
        App app = new App(ui);

        app.lookFor(memberId);
    }
}
