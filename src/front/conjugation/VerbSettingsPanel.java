package front.conjugation;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class VerbSettingsPanel extends JPanel implements ActionListener {

  private Mode modI;
  private Tense tensI;

  public VerbSettingsPanel(){
    modI = Mode.getInstance();
    tensI = Tense.getInstance();
    buildPanel();
  }

  private JPanel modePane;
  private JPanel tensePane;

  private JLabel modeLabel;
  private JLabel tenseLabel;

  private JComboBox<String> modeCombo;
  private JComboBox<String> tenseCombo;

  private void buildPanel(){
    modePane = new JPanel();
    modePane.setLayout(new BoxLayout(modePane, BoxLayout.Y_AXIS));
    add(modePane);

    modeLabel = new JLabel("Mode");
    modePane.add(modeLabel);
    modeLabel.setVisible(true);


    modeCombo = new JComboBox<>(modI.getModesStrings());
    modeCombo.setSelectedItem(modI.actual);
    modePane.add(modeCombo);
    modeCombo.setVisible(true);

    tensePane = new JPanel();
    tensePane.setLayout(new BoxLayout(tensePane, BoxLayout.Y_AXIS));
    add(tensePane);

    tenseLabel = new JLabel("Tense");
    tensePane.add(tenseLabel);
    tenseLabel.setVisible(true);


    tenseCombo = new JComboBox<>();
    tenseCombo.setModel(new DefaultComboBoxModel<>(tensI.getTensesStrings(Integer.parseInt(modI.actual))));
    tenseCombo.setSelectedItem(tensI.actual);
    tenseCombo.addActionListener(this);
    tensePane.add(tenseCombo);
    tenseCombo.setVisible(true);


    ActionListener modeManager = new ModeManager(modeCombo, tenseCombo);
    modeCombo.addActionListener(modeManager);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    if(arg0.getSource() == tenseCombo){
      String val = (String) tenseCombo.getSelectedItem();
      tensI.actual = tensI.getIntValForMode( Integer.parseInt(modI.actual), val);
    }
  }
  
}
