package front.connection;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import front.conjugation.ConjugationRequest;
import front.conjugation.Mode;
import front.conjugation.Tense;
import front.utils.Utils;

public class ConnectionPage extends JDialog implements ActionListener{
    private JPanel contentPane;
    private JPanel urlPane;
    private JPanel portPane;

    private JTextField urlField;
    private JTextField portField;

    private JLabel urlLabel;
    private JLabel portLabel;

    private JLabel urlErrorLabel;
    private JLabel portErrorLabel;
    private JLabel connectErrorLabel;

    private JButton connectButton;

    public ConnectionPage() {
        this(null,true);
    }

    public ConnectionPage(final JFrame parent, boolean modal){
        super(parent, modal);
        buildPage();
    }

    private void buildPage(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300,200);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        setContentPane(contentPane);

        urlPane = new JPanel();
        urlPane.setLayout(new BoxLayout(urlPane, BoxLayout.Y_AXIS));

        urlLabel = new JLabel("URL");
        urlPane.add(urlLabel);
        urlField = new JTextField();
        urlPane.add(urlField);
        urlErrorLabel = new JLabel("Indiquez un url de serveur");
        urlErrorLabel.setForeground(Color.RED);
        urlPane.add(urlErrorLabel);
        urlErrorLabel.setVisible(false);

        contentPane.add(urlPane);

        portPane = new JPanel();
        portPane.setLayout(new BoxLayout(portPane, BoxLayout.Y_AXIS));

        portLabel = new JLabel("Port");
        portPane.add(portLabel);
        portField = new JTextField();
        portPane.add(portField);
        portErrorLabel = new JLabel("Indiquez un port de serveur");
        portErrorLabel.setForeground(Color.RED);
        portPane.add(portErrorLabel);
        portErrorLabel.setVisible(false);

        contentPane.add(portPane);

        connectButton = new JButton("se connecter");
        connectButton.addActionListener(this);

        contentPane.add(connectButton);

        connectErrorLabel = new JLabel("Erreur de connexion au serveur");
        contentPane.add(connectErrorLabel);
        connectErrorLabel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        boolean valid = true;
        if(portField.getText().trim().equals("") || Integer.parseInt(portField.getText().trim()) == 0){
            portErrorLabel.setVisible(true);
            valid = false;
        }
        if(urlField.getText().trim().equals("")){
            urlErrorLabel.setVisible(true);
            valid = false;
        }
        if(valid){
            urlErrorLabel.setVisible(false);
            portErrorLabel.setVisible(false);
            connectErrorLabel.setVisible(false);
            if(initConnection())
              setVisible(false);
            else
              connectErrorLabel.setVisible(true);
        }
    }

    private boolean initConnection(){
      ConnectionData.getInstance().setString(urlField.getText().trim());
      ConnectionData.getInstance().setPort(Integer.parseInt(portField.getText().trim()));
      String jsonModes = ConjugationRequest.getModes();
      if(jsonModes == null){
        return false;
      }
      Map<String,String> modes = Utils.getMap(jsonModes);
      Mode.getInstance().setModes(modes);
      Mode.getInstance().actual = "0";
      return ConjugationRequest.updateTenses();
    }
}
