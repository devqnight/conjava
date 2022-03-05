package front;

import front.window.MainWindow;

public class StartClient {
    public static void main(String[] args) {
        try {
            MainWindow.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
