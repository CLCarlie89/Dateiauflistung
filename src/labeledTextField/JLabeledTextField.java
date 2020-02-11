package labeledTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JLabeledTextField extends JPanel {

	public static final long VERY_SMALL = 1;
	public static final long SMALL = 2;
	public static final long NORMAL = 3;

	private JLabel label = new JLabel("Label", SwingConstants.CENTER);
	private JTextField textfield = new JTextField();

	private int ausrichtung = 0;

	private long small = 3;

	public JLabeledTextField() {
		initGUI();
	}

	public JLabeledTextField(int small) {
		this.small = small;
		initGUI();
	}

	/**
	 * @param: defaulttext - Defaultext für das Textfied labeltext - Text für
	 *         das Label ausrichtung - Bestimmt die ausrichtung des Labels im
	 *         Bezug auf das Textfeld mögliche Werte sind SwingConstants: NORTH,
	 *         SOUTH, LEFT, RIGHT
	 */
	public JLabeledTextField(String defaulttext, String labeltext, int ausricht) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);

	}

	/**
	 * 
	 * @param labeltext
	 *            - Text für das Label
	 */
	public JLabeledTextField(String labeltext) {

		initGUI();
		label.setText(labeltext);
	}

	/**
	 * @param labeltext
	 *            - Text für das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 */
	public JLabeledTextField(String labeltext, int ausricht) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
	}

	/**
	 * @param labeltext
	 *            - Text für das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String labeltext, String tooltip) {
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext für das Textfied
	 * @param labeltext
	 *            - Text für das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String defaulttext, String labeltext, String tooltip) {
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param labeltext
	 *            - Text für das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String labeltext, int ausricht, String tooltip) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext für das Textfied
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(int ausricht, String defaulttext, String tooltip) {
		this.ausrichtung = ausricht;
		initGUI();
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext für das Textfied
	 * @param labeltext
	 *            - Text für das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String defaulttext, String labeltext, int ausricht, String tooltip) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
		textfield.setText(defaulttext);

	}

	/**
	 * @param: defaulttext - Defaultext für das Textfied labeltext - Text für
	 *         das Label ausrichtung - Bestimmt die ausrichtung des Labels im
	 *         Bezug auf das Textfeld mögliche Werte sind SwingConstants: NORTH,
	 *         SOUTH, LEFT, RIGHT
	 */
	public JLabeledTextField(String defaulttext, String labeltext, int ausricht, int small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);

	}

	/**
	 * 
	 * @param labeltext
	 *            - Text für das Label
	 */
	public JLabeledTextField(String labeltext, long small) {
		this.small = small;
		initGUI();
		label.setText(labeltext);

	}

	/**
	 * @param labeltext
	 *            - Text für das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 */
	public JLabeledTextField(String labeltext, int ausricht, long small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		label.setText(labeltext);

	}

	/**
	 * @param labeltext
	 *            - Text für das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String labeltext, String tooltip, long small) {
		this.small = small;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext für das Textfied
	 * @param labeltext
	 *            - Text für das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String defaulttext, String labeltext, String tooltip, long small) {
		this.small = small;
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param labeltext
	 *            - Text für das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String labeltext, int ausricht, String tooltip, long small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext für das Textfied
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(int ausricht, String defaulttext, String tooltip, long small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext für das Textfied
	 * @param labeltext
	 *            - Text für das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld mögliche Werte sind SwingConstants: NORTH, SOUTH,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField(String defaulttext, String labeltext, int ausricht, String tooltip, long small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
		textfield.setText(defaulttext);

	}

	private void initGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gbc_label = new GridBagConstraints();
		GridBagConstraints gbc_textfield = new GridBagConstraints();

		int width = 30;
		int height = 450;

		if (small == VERY_SMALL) {

			if (ausrichtung == 0 || ausrichtung == SwingConstants.LEFT) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 1;
				gbc_textfield.gridy = 0;

				height = 30;
				width = 300;

			}

			if (ausrichtung == SwingConstants.RIGHT) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;

				height = 30;
				width = 300;
			}

			if (ausrichtung == SwingConstants.NORTH) {
				gridBagLayout.columnWidths = new int[] { 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;

				height = 60;
				width = 150;
			}

			if (ausrichtung == SwingConstants.SOUTH) {
				gridBagLayout.columnWidths = new int[] { 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 1;

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;

				height = 60;
				width = 150;
			}
		}
		if (small == SMALL) {

			if (ausrichtung == 0 || ausrichtung == SwingConstants.LEFT) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 1;
				gbc_textfield.gridy = 0;

				height = 30;
				width = 300;
			}

			if (ausrichtung == SwingConstants.RIGHT) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;

				height = 30;
				width = 300;
			}

			if (ausrichtung == SwingConstants.NORTH) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;

				height = 60;
				width = 300;
			}

			if (ausrichtung == SwingConstants.SOUTH) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 1;

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;

				height = 60;
				width = 300;
			}
		}
		gbc_label.fill = GridBagConstraints.NONE;
		gbc_textfield.fill = GridBagConstraints.NONE;
		
		if (small == NORMAL) {


			if (ausrichtung == 0 || ausrichtung == SwingConstants.LEFT) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 10.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 1;
				gbc_textfield.gridy = 0;

				height = 100;
				width = 450;
			}

			if (ausrichtung == SwingConstants.RIGHT) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 10.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 2;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;

				height = 100;
				width = 450;
			}

			if (ausrichtung == SwingConstants.NORTH) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;

				height = 100;
				width = 450;
			}

			if (ausrichtung == SwingConstants.SOUTH) {
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 1;

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;

				height = 60;
				width = 450;
			}

			gbc_label.fill = GridBagConstraints.NONE;
			gbc_textfield.fill = GridBagConstraints.HORIZONTAL;
		}

		gbc_label.insets = new Insets(5, 5,5, 5);
		gbc_textfield.insets = new Insets(5, 5,5, 5);
	

		setLayout(gridBagLayout);
		add(label, gbc_label);
		add(textfield, gbc_textfield);

		Dimension d = new Dimension(width, height);

		this.setMaximumSize(d);

	}

	/**
	 * Setzt den Text des Labels auf text
	 * 
	 * @param text
	 */
	public void setTextLabel(String text) {
		label.setText(text);
	}

	/**
	 * 
	 * @return string - String der dem Text des Labels entspricht
	 */
	public String getTextLabel() {
		return label.getText();
	}

	/**
	 * Setzt den Text des Textfields auf text
	 * 
	 * @param text
	 */
	public void setTextTextField(String text) {
		textfield.setText(text);
	}

	/**
	 * 
	 * @return string - String der dem Text des Textfields entspricht
	 */
	public String getTextTextField() {
		return textfield.getText();
	}

	/**
	 * Bestimmt ob das Textfeld editierbar ist
	 * 
	 * @param b
	 */
	public void setEditable(boolean b) {

		textfield.setEditable(b);
	}

	/**
	 * ändert die Hintergrundfarbe des Textfields
	 * 
	 * @param color
	 */
	public void setTextfieldBackground(Color color) {
		textfield.setBackground(color);
	}

	/**
	 * setzt den tooltip für das LabeledTextfield
	 * 
	 * @param text
	 *            - der String der den Tooltip repräsentiert
	 */
	@Override
	public void setToolTipText(String text) {
		textfield.setToolTipText(text);
		label.setToolTipText(text);
	}
	
	public void setAusrichtung (int ausrichtung){
		this.ausrichtung=ausrichtung;
	}

			
	public void setSmall(long small){
		this.small=small;
	}
}
