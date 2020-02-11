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
public class JLabeledTextField2 extends JPanel {

	//Gr�sse
	public static final long VERY_SMALL = 1;
	public static final long SMALL = 2;
	public static final long NORMAL = 3;

	//Postion
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int TOP	= 3;
	public static final int BOTTOM = 4;

	public static final int TOP_RIGHT = 31;
	public static final int TOP_LEFT = 32;
	public static final int TOP_CENTER = 35;

	public static final int BOTTOM_RIGHT = 41;
	public static final int BOTTOM_LEFT = 42;
	public static final int BOTTOM_CENTER = 45;

	//Componenten
	private JLabel label = new JLabel("Label", SwingConstants.CENTER);
	private JTextField textfield = new JTextField();

	//Variablen
	private int ausrichtung = 0;
	private long small = 3;

	public JLabeledTextField2() {
		initGUI();
	}

	public JLabeledTextField2(int small) {
		this.small = small;
		initGUI();
	}

	/**
	 * @param: defaulttext - Defaultext f�r das Textfied labeltext - Text f�r
	 *         das Label ausrichtung - Bestimmt die ausrichtung des Labels im
	 *         Bezug auf das Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP,
	 *         BOTTOM, LEFT, RIGHT
	 */
	public JLabeledTextField2(String defaulttext, String labeltext, int ausricht) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);

	}

	/**
	 * 
	 * @param labeltext
	 *            - Text f�r das Label
	 */
	public JLabeledTextField2(String labeltext) {

		initGUI();
		label.setText(labeltext);
	}

	/**
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 */
	public JLabeledTextField2(String labeltext, int ausricht) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
	}

	/**
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String labeltext, String tooltip) {
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext f�r das Textfied
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String defaulttext, String labeltext, String tooltip) {
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String labeltext, int ausricht, String tooltip) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext f�r das Textfied
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(int ausricht, String defaulttext, String tooltip) {
		this.ausrichtung = ausricht;
		initGUI();
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext f�r das Textfied
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String defaulttext, String labeltext, int ausricht, String tooltip) {
		this.ausrichtung = ausricht;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
		textfield.setText(defaulttext);

	}

	/**
	 * @param: defaulttext - Defaultext f�r das Textfied labeltext - Text f�r
	 *         das Label ausrichtung - Bestimmt die ausrichtung des Labels im
	 *         Bezug auf das Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP,
	 *         BOTTOM, LEFT, RIGHT
	 */
	public JLabeledTextField2(String defaulttext, String labeltext, int ausricht, int small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);

	}

	/**
	 * 
	 * @param labeltext
	 *            - Text f�r das Label
	 */
	public JLabeledTextField2(String labeltext, long small) {
		this.small = small;
		initGUI();
		label.setText(labeltext);

	}

	/**
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 */
	public JLabeledTextField2(String labeltext, int ausricht, long small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		label.setText(labeltext);

	}

	/**
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String labeltext, String tooltip, long small) {
		this.small = small;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext f�r das Textfied
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String defaulttext, String labeltext, String tooltip, long small) {
		this.small = small;
		initGUI();
		label.setText(labeltext);
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String labeltext, int ausricht, String tooltip, long small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		label.setText(labeltext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext f�r das Textfied
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(int ausricht, String defaulttext, String tooltip, long small) {
		this.ausrichtung = ausricht;
		this.small = small;
		initGUI();
		textfield.setText(defaulttext);
		setToolTipText(tooltip);
	}

	/**
	 * @param defaulttext
	 *            - Defaultext f�r das Textfied
	 * @param labeltext
	 *            - Text f�r das Label
	 * @param ausrichtung
	 *            - Bestimmt die ausrichtung des Labels im Bezug auf das
	 *            Textfeld m�gliche Werte sind TOP_RIGHT, TOP_LEFT, TOP_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, TOP, BOTTOM,
	 *            LEFT, RIGHT
	 * @param tooltip
	 *            - Text des Tooltips
	 */
	public JLabeledTextField2(String defaulttext, String labeltext, int ausricht, String tooltip, long small) {
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

		int width = 50;
		int height = 450;
		
		
		
		if (small == VERY_SMALL) {

			
			if (ausrichtung == 0 || ausrichtung == LEFT ) {

				//1 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;
	
				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 1;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;				

				height = 50;
				width = 500;

			}

			if (ausrichtung == RIGHT) {

				//1 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;	

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;
		

				height = 50;
				width = 500;
			}

			if (ausrichtung == TOP || ausrichtung == TOP_RIGHT || 
				ausrichtung == TOP_LEFT || ausrichtung == TOP_CENTER) {

				//2 Zeile x 1 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;
	

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;
	

				height = 60;
				width = 150;
			}

			if (ausrichtung == BOTTOM || ausrichtung == BOTTOM_RIGHT || 
				ausrichtung == BOTTOM_LEFT || ausrichtung == BOTTOM_CENTER) {

				//2 Zeile x 1 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 1;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;			

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;

				height = 60;
				width = 150;
			}

			gbc_label.fill = GridBagConstraints.NONE;
			gbc_textfield.fill = GridBagConstraints.NONE;
		}

		if (small == SMALL) {

			if (ausrichtung == 0 || ausrichtung == LEFT) {

				//1 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;	

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 1;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;

				height = 50;
				width = 500;
			}

			if (ausrichtung == RIGHT) {

				//1 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;	

				gbc_textfield.gridwidth = 1;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;

				height = 50;
				width = 500;
			}

			if (ausrichtung == TOP || ausrichtung == TOP_LEFT ) {

				//2 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;		

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;			

				height = 60;
				width = 300;
			}

			if (ausrichtung == TOP_RIGHT ) {

				//2 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;		

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;			

				height = 60;
				width = 300;
			}

			if (ausrichtung == TOP_CENTER) {

				//2 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 2;		

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;			

				height = 60;
				width = 300;
			}

			if (ausrichtung == BOTTOM || ausrichtung == BOTTOM_LEFT) {

				//2 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 1;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;		

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;	
				
				height = 60;
				width = 300;
			}	

			if (ausrichtung == BOTTOM_RIGHT ) {

				//2 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 1;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;		

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;	
				
				height = 60;
				width = 300;
			}
	
			if (ausrichtung == BOTTOM_CENTER) {

				//2 Zeile x 2 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 1;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 2;		

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;	
				
				height = 60;
				width = 300;
			}

			gbc_label.fill = GridBagConstraints.NONE;
			gbc_textfield.fill = GridBagConstraints.NONE;
		}

		
		if (small == NORMAL) {

			if (ausrichtung == 0 || ausrichtung == LEFT) {

				//1 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 10.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 1;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;

				height = 50;
				width = 450;
			}

			if (ausrichtung == RIGHT) {

				//1 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 10.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 2;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;

				gbc_textfield.gridwidth = 2;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;

				height = 50;
				width = 450;
			}

			if (ausrichtung == TOP|| ausrichtung == TOP_LEFT ) {

				//2 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;				

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;				

				height = 60;
				width = 450;
			}

			if (ausrichtung == TOP_RIGHT) {

				//2 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 2;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;				

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;				

				height = 60;
				width = 450;
			}

			if (ausrichtung == TOP_CENTER) {

				//2 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 0;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;				

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 1;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;				

				height = 60;
				width = 450;
			}

			if (ausrichtung == BOTTOM || ausrichtung == BOTTOM_LEFT ) {

				//2 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 0;
				gbc_label.gridy = 1;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;				

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;			

				height = 60;
				width = 450;
			}

			if (ausrichtung == BOTTOM_RIGHT) {

				//2 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 2;
				gbc_label.gridy = 1;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;				

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;			

				height = 60;
				width = 450;
			}

			if (ausrichtung == BOTTOM_CENTER) {

				//2 Zeile x 3 Spalten
				gridBagLayout.columnWidths = new int[] { 100, 100, 100, 0 };
				gridBagLayout.rowHeights = new int[] { 50, 50, 0 };
				gridBagLayout.columnWeights = new double[] { 100.0, 100.0, 100.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

				gbc_label.gridx = 1;
				gbc_label.gridy = 1;
				gbc_label.ipadx = 10;
       			gbc_label.ipady = 0;
				gbc_label.gridwidth = 1;				

				gbc_textfield.gridwidth = 3;
				gbc_textfield.gridx = 0;
				gbc_textfield.gridy = 0;
				gbc_textfield.ipadx = 10;
       			gbc_textfield.ipady = 0;			

				height = 60;
				width = 450;
			}

			gbc_label.fill = GridBagConstraints.NONE;
			gbc_textfield.fill = GridBagConstraints.HORIZONTAL;
		}

		gbc_label.insets = new Insets(5, 5, 5, 5);
		gbc_textfield.insets = new Insets(5, 5, 5, 5);




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
	 * �ndert die Hintergrundfarbe des Textfields
	 * 
	 * @param color
	 */
	public void setTextfieldBackground(Color color) {
		textfield.setBackground(color);
	}

	/**
	 * setzt den tooltip f�r das LabeledTextfield
	 * 
	 * @param text
	 *            - der String der den Tooltip repr�sentiert
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
