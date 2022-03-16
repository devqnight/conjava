package front.conjugation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ModeManager implements ActionListener {

  

  private Mode modI;
  private JComboBox<String> modeCombo;
  private JComboBox<String> tenseCombo;
  private Tense tensI;

  public ModeManager(JComboBox<String> mode, JComboBox<String> tense){
    this.modeCombo = mode;
    this.tenseCombo = tense;
    this.modI = Mode.getInstance();
    this.tensI = Tense.getInstance();
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
      modI.actual = modI.getIntVal((String) modeCombo.getSelectedItem());
      ConjugationRequest.updateTenses();
      tenseCombo.removeAllItems();
      tenseCombo.setModel(new DefaultComboBoxModel<>(tensI.getTensesStrings(Integer.parseInt(modI.actual))));
      tenseCombo.setSelectedItem(tensI.getDefaultTense(Integer.parseInt(modI.actual)));
  }
  
}
