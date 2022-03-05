package front.conjugation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import front.connection.ConnectionPage;

public class ConjugationPage extends JFrame implements ActionListener{
    private ConnectionPage connectionPage;

    public ConjugationPage(){
        connectionPage = new ConnectionPage(this, true);
        connectionPage.setVisible(true);

        buildPage();
    }


    private JPanel contentPane;

    private JPanel verbSettings;

    private JTextArea conjugations;
    private JTextField verb;

    private JButton conjugate;

    private void buildPage(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(300,200);

        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        setContentPane(contentPane);

        verbSettings = new JPanel();
        verbSettings.setLayout(new BoxLayout(verbSettings, BoxLayout.Y_AXIS));
        contentPane.add(verbSettings);

        verb = new JTextField();
        verbSettings.add(verb);

        conjugate = new JButton("Conjuguer");
        conjugate.addActionListener(this);
        contentPane.add(conjugate);

        conjugations = new JTextArea();
        contentPane.add(conjugations);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String res = ConjugationRequest.conjugate(verb.getText().trim());

        conjugations.setText(res);
    }

}
