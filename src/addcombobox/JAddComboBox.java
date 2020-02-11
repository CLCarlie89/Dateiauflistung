/**
 * 
 */
package addcombobox;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;




//import models.MyListModel;

/**
 * @author cliebsch
 * 
 */
public class JAddComboBox<E> extends JPanel {

	private static final long serialVersionUID = 1L;

	private MyComboBoxModel<E> model = new MyComboBoxModel<>();
	private JComboBox<E> combobox = new JComboBox<>(model);
	private JTextField txtf = new JTextField();
	private JButton addtotxtf = new JButton("ADD ins Textfeld");
	private JButton reset = new JButton("Reset");

	private JButton addtolist = new JButton("ADD zur Liste");

	private JButton remove = new JButton("Remove von Liste");

	private boolean singel = false;

	public JAddComboBox() {

		createPanel();
	}

	/**
	 * @param singel
	 *            zu nutzen um nach dem adden ins Textfeld nur das aktuelle
	 *            elemente zu adden true nur ein element steht immer drin
	 * */
	public JAddComboBox(boolean singel) {
		this.singel = singel;
		createPanel();
	}

	public void createPanel() {
		String text = "Um von hand geschriebene Daten in die Liste zu übertragen";
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 150, 150, 150, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0,
				100.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Textfield begin
		GridBagConstraints gbc_txtf = new GridBagConstraints();
		gbc_txtf.fill = GridBagConstraints.BOTH;
		gbc_txtf.gridwidth = 4;
		gbc_txtf.insets = new Insets(0, 0, 5, 0);
		gbc_txtf.gridx = 0;
		gbc_txtf.gridy = 0;
		add(txtf, gbc_txtf);

		// Combobox begin
		GridBagConstraints gbc_combobox = new GridBagConstraints();
		gbc_combobox.fill = GridBagConstraints.BOTH;
		gbc_combobox.gridwidth = 4;
		gbc_combobox.insets = new Insets(0, 0, 5, 0);
		gbc_combobox.gridx = 0;
		gbc_combobox.gridy = 1;
		combobox.setMaximumRowCount(25);
		add(combobox, gbc_combobox);

		// Buttons begin
		GridBagConstraints gbc_addtotxtf = new GridBagConstraints();
		gbc_addtotxtf.fill = GridBagConstraints.BOTH;
		gbc_addtotxtf.insets = new Insets(0, 0, 0, 5);
		gbc_addtotxtf.gridx = 0;
		gbc_addtotxtf.gridy = 2;
		addtotxtf
				.setToolTipText("Fügt den aktuellen Inhalt der ComboBox dem Textfeld zu");
		addtotxtf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addtotxtf_actionPerformed(e);

			}
		});
		add(addtotxtf, gbc_addtotxtf);

		GridBagConstraints gbc_reset = new GridBagConstraints();
		gbc_reset.fill = GridBagConstraints.BOTH;
		gbc_reset.insets = new Insets(0, 0, 0, 5);
		gbc_reset.gridx = 1;
		gbc_reset.gridy = 2;
		reset.setToolTipText("Entfernt ALLE einträge im Textfeld");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset_actionPerformed(e);

			}
		});
		add(reset, gbc_reset);

		GridBagConstraints gbc_addtolist = new GridBagConstraints();
		gbc_addtolist.fill = GridBagConstraints.BOTH;
		gbc_addtolist.insets = new Insets(0, 0, 0, 5);
		gbc_addtolist.gridx = 2;
		gbc_addtolist.gridy = 2;
		addtolist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addtolist_actionPerformed(e);

			}
		});
		addtolist.setToolTipText(text);
		add(addtolist, gbc_addtolist);

		GridBagConstraints gbc_remove = new GridBagConstraints();
		gbc_remove.fill = GridBagConstraints.BOTH;
		gbc_remove.gridx = 3;
		gbc_remove.gridy = 2;
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				remove_actionPerformed(e);

			}
		});
		add(remove, gbc_remove);

	}

	protected void remove_actionPerformed(ActionEvent e) {
		model.removeElementAt(combobox.getSelectedIndex());
	}

	protected void addtolist_actionPerformed(ActionEvent e) {
		@SuppressWarnings("unchecked")
		E element = (E) txtf.getText();

		model.addElementAt(0, element);

	}

	protected void reset_actionPerformed(ActionEvent e) {
		txtf.setText("");
	}

	protected void addtotxtf_actionPerformed(ActionEvent e) {
		int index = combobox.getSelectedIndex();
		E element = model.getElementAt(index);
		if (singel) {
			txtf.setText("");
			String text = element.toString();
			String text1 = txtf.getText();
			txtf.setText(text + text1);
			model.moveElementInListToIndex(index, 0);

		} else {
			String text = element.toString();
			String text1 = txtf.getText();
			txtf.setText(text + ", " + text1);
		}
	}

	public void setToolTipTextComboBox(String tooltip) {
		combobox.setToolTipText(tooltip);
	}

	public String getTextTextField() {
		return txtf.getText();
	}

	public void setTextTextfield(String text) {
		txtf.setText(text);
	}

	public void addItemListener(ItemListener aListener) {
		combobox.addItemListener(aListener);
	}

	public void addElement(E element) {
		model.addElement(element);
	}

	public void addElement(E[] elements) {
		model.addElements(elements);
	}

	public void addElement(List<E> elements) {
		model.addElements(elements);
	}

	public void addElementAt(int index, E element) {

		model.addElementAt(index, element);

	}

	/** Gibt das Aktuelle Element wieder */
	public E getElement() {
		return model.getElementAt(combobox.getSelectedIndex());
	}

	/** Gibt das Aktuelle Element wieder */
	public E getElement(int index) {
		return model.getElementAt(index);
	}

	public ArrayList<E> getElements() {
		ArrayList<E> liste = new ArrayList<E>();
		for (int i = 0; i < model.getSize(); i++) {
			liste.add(model.getElementAt(i));
		}
		return model.getElements();
	}

	public void setSelectedIndex(int i) {
		combobox.setSelectedIndex(i);

	}

	public void setBackgroundComboBox(Color bg) {
		combobox.setBackground(bg);

	}

	public JButton getAddtotxtf() {
		return addtotxtf;
	}

	public JButton getReset() {
		return reset;
	}

	public JButton getAddtolist() {
		return addtolist;
	}

	public JButton getRemove() {
		return remove;
	}

}
