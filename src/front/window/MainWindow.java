package front.window;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.formdev.flatlaf.FlatLightLaf;

import front.conjugation.ConjugationPage;

public class MainWindow extends JFrame {
    public static void start() throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        ConjugationPage conjugationPage = new ConjugationPage();
        conjugationPage.setSize(500,300);
        conjugationPage.setVisible(true);
    }
}
