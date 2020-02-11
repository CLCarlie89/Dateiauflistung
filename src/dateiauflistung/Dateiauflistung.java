
package dateiauflistung;

import hilfe.Hilfe;
import hilfe.HilfeData;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

import labeledTextField.JLabeledTextField;
import mydefaultmodels.MyArrayList;
import mydefaultmodels.MyFileTableModel;
import addcombobox.JAddComboBox;

@SuppressWarnings ( "serial" )
public class Dateiauflistung extends JFrame implements Runnable {

	private String filterstrings[] = { "ass" , "jar" , "exe" , "info" , "pdf" , "class" , "cvs" , "h" , "cpp" , "mdsp" , "dev" , "rc" , "dsp" , "layout" , "ini" , "sfv" , "nds" , "gba" , "gbc" ,
			"sgm" , "ds8" , "rgn" , "gb" , "am" , "aps" , "dsw" , "ncb" , "cpp~" , "mak" , "h~" , "win" , "opt" , "plg" , "sh" , "o" , "def" , "dep" , "dsv" , "ds0" , "ds1" , "ds2" , "ds4" , "ds3" ,
			"ds5" , "ds6" , "ds7" , "ds8" , "ds9" , "so" , "xls" , "txt" , "doc" , "dot" , "odt" , "sxw" , "rtf" , "jpg" , "jpeg" , "jpe" , "gif" , "bmp" , "tif" , "tiff" , "png" , "mp3" , "wma" ,
			"ogg" , "au" , "aif" , "aiff" , "wav" , "avi" , "mkv" , "mpg" , "mpeg" , "wmv" , "mov" , "divx" , "mp4" , "m4v" , "asf" , "iso" , "bin" , "ink" , "cue" , "vcd" , "img" , "ccd" , "rar" ,
			"zip" , "tgz" , "7z" , "nfo" , "gz" , "tar" , "java" , "sdx" , "sds" , "msi" , "log" , "dll" , "dat" , "css" , "tga" , "html" , "htm" , "bik" , "inc" , "tex" , "zei" , "cach" , "sze" ,
			"hig" , "ddf" , "scp" , "sav" , "torrent" };
	private String filterlist[] = { "doc,dot,odt,sxw,rtf,pdf,txt" , "jpg,jpeg,jpe,gif,bmp,tif,tiff,png" , "mp3,wma,ogg,au,aif,aiff,wav" , "avi,bik,mpg,mpeg,mkv,wmv,mov,divx,mp4,m4v,asf" ,
			"iso,bin,cue,vcd,img,ccd" , "rar,zip,tgz,7z,gz,tar" };

	private JMenuBar menuBar = new JMenuBar();

	private JMenu mnDatei = new JMenu( "Datei" );
	private JMenuItem mntmffnen = new JMenuItem( "\u00D6ffnen..." );
	private JMenuItem mntmSpeichern = new JMenuItem( "Speichern..." );
	private JMenuItem mntmBeenden = new JMenuItem( "Beenden" );

	private JMenu mnHilfe = new JMenu( "Hilfe" );
	private JMenuItem mntmHilfe = new JMenuItem( "Hilfe" );
	private JMenuItem mntmAbout = new JMenuItem("About");

	private JPanel p_north = new JPanel();
	private JPanel p_north_center = new JPanel();
	private JPanel p_north_north = new JPanel();
	private JPanel p_north_south = new JPanel();
	private JPanel p_north_south_1 = new JPanel();
	private JPanel p_north_south_2 = new JPanel();

	private JCheckBox chbdateien = new JCheckBox( "Dateien sammeln" );
	private JCheckBox chbordner = new JCheckBox( "Ordner sammeln" );

	private ButtonGroup btgroup = new ButtonGroup();
	private JRadioButton rbtignorienen = new JRadioButton( "Gew\u00e4hlte Dateitypen ignorieren" );
	private JRadioButton rbtnutzen = new JRadioButton( "Gew\u00e4hlte Dateitypen nutzen" );

	private JButton btnOeffnen = new JButton( "\u00D6ffnen" );
	private JButton remove = new JButton( "Aus Tabellenansicht l\u00F6schen" );
	private JButton speichern = new JButton( "Speichern" );
	private JButton btnReset = new JButton( "Reset" );
	private JButton btnStart = new JButton( "Start" );

	private JTabbedPane tabbedPane = new JTabbedPane( JTabbedPane.TOP );

	private JScrollPane jScrollPaneErgebnis = new JScrollPane();
	private JTextArea ergebnis = new JTextArea( "" );

	private JScrollPane jscrollPaneTable = new JScrollPane();

	/** Tablemodel für die Auflistung der Dateien und Ordner */
	private MyFileTableModel model = new MyFileTableModel();
	private JTable table = new JTable( model );

	/** Tablemodel für die Auflistung der Suchergebnise */
	private MyFileTableModel model_suche = new MyFileTableModel();
	private JTable table_suche = new JTable( model_suche );

	private JAddComboBox < String > addcombo = new JAddComboBox < String >();

	private JTextField pfad = new JTextField();
	private JLabel status = new JLabel( "Anzahl der Ordner und Dateien: 0" );

	private Thread thread = new Thread( this );

	private String speicherpfad = "";

	private JDialog hilfe = new JDialog( this );
	private final JTabbedPane tabbedPane_1 = new JTabbedPane( JTabbedPane.TOP );
	private final JPanel panel = new JPanel();
	private final JScrollPane scrollPaneFehler = new JScrollPane();

	private final JTextArea textAreaFehler = new JTextArea();

	private final JPanel p_south = new JPanel();
	private JScrollPane jScrollPaneSuche = new JScrollPane();
	private JLabeledTextField suche = new JLabeledTextField( "Suche :" , SwingConstants.LEFT , JLabeledTextField.NORMAL );
	private JButton btsuchen = new JButton( "Suche" );
	private JButton btubernehmen = new JButton( "\u00dcbernehmen" );
	private JButton btsuchereset = new JButton( "Reset Suche" );
	private JPanel p_south_south = new JPanel();
	private final JPanel p_north_north_south = new JPanel();
	private final JButton btnAbbruch = new JButton( "Abbruch" );

	public static void main( String[] args ) {

		new Dateiauflistung();
	}

	public Dateiauflistung() {

		// Frame-Initialisierung
		setTitle( "Dateiauflistung" );

		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

		int frameWidth = 750;
		int frameHeight = 500;
		Dimension d = new Dimension( frameWidth , frameHeight );
		setMinimumSize( d );
		d = Toolkit.getDefaultToolkit().getScreenSize();
		setMaximumSize( d );

		initButtons();
		initGUI();

		pack();

		setPosition();

		setResizable( true );
		setVisible( true );
	}

	public void setMenu() {

		mnDatei.add( mntmffnen );
		mnDatei.add( mntmSpeichern );
		mnDatei.add( mntmBeenden );

		mnHilfe.add( mntmHilfe );
		mnHilfe.add(mntmAbout);

		menuBar.add( mnDatei );
		menuBar.add( mnHilfe );

		setJMenuBar( menuBar );
	}

	public MyArrayList < MyFile > dateien_sammel( File f ) {

		if ( !chbdateien.isSelected() && !chbordner.isSelected() ) {
			return null;
		}

		File v_datei;

		boolean nutzen = true;

		if ( getSelectedRadioButton( btgroup ) == "ignorienen" ) {
			nutzen = false;
		} else {
			if ( getSelectedRadioButton( btgroup ) == "nutzen" ) {
				nutzen = true;
			}
		}

		MyFileFilter filter = new MyFileFilter( addcombo.getTextTextField() , nutzen );

		File[] files2 = null;
		v_datei = f;
		files2 = v_datei.listFiles( filter );

		MyArrayList < MyFile > daten = new MyArrayList < MyFile >();
		int l = files2.length;

		for ( int i = 0 ; i < l ; i++ ) {

			String typ = "";
			if ( files2[i].isFile() ) {
				typ = MyFile.FILE;
			} else {
				if ( files2[i].isDirectory() ) {
					typ = MyFile.DIRECTORY;
				}
			}
			daten.add( new MyFile( typ , files2[i] ) );

			if ( getThread().isInterrupted() ) {
				btnStart.setEnabled( true );
				break;
			}
			
			if ( files2[i].isDirectory() ) {
				daten.addAll( dateien_sammel( files2[i] ) );
			}

		}

		return daten;
	}

	public MyArrayList < MyFile > filterdaten( MyArrayList < MyFile > daten ) {

		MyArrayList < MyFile > dateien = daten;
		if ( chbdateien.isSelected() && !chbordner.isSelected() ) {
			for ( int i = 0 ; i < dateien.size() ; i++ ) {
				MyFile fi = dateien.get( i );
				if ( fi.isDirectory() ) {

					dateien.remove( i );
					i--;
				}
			}
		}

		if ( !chbdateien.isSelected() && chbordner.isSelected() ) {
			for ( int i = 0 ; i < dateien.size() ; i++ ) {
				MyFile fi = dateien.get( i );
				if ( fi.isFile() ) {

					dateien.remove( i );
					i--;
				}
			}
		}
		return dateien;
	}

	public String getMarker( String text ) {

		String ext = "";
		String s = text;
		int i = s.lastIndexOf( ';' );

		if ( i > -1 ) {
			ext = s.substring( i + 1 ).toLowerCase();
		}
		return ext.toUpperCase();
	}

	/**
	 * Bestimmt den Gew�hlten RadioButton aus der gegebenen ButtonGroup Entnommen aus dem JavaBuch oder aus dem
	 * JavaTutorial.
	 * 
	 * @param bg
	 * @return den text des selectierten RadioButton
	 */
	public String getSelectedRadioButton( ButtonGroup bg ) {

		for ( Enumeration < AbstractButton > e = bg.getElements() ; e.hasMoreElements() ; ) {
			AbstractButton b = e.nextElement();
			if ( b.isSelected() ) {
				return b.getActionCommand();
			}
		}
		return null;
	}

	/**
	 * @return the thread
	 */
	public Thread getThread() {

		if ( thread == null ) {
			thread = new Thread( this );
		}
		return thread;
	}

	public void initButtons() {

		btnOeffnen.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				btnOeffnen_ActionPerformed( evt );
			}
		} );
		btnStart.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				start_ActionPerformed( evt );
			}
		} );
		p_north_north_south.setLayout( new GridLayout( 1 , 2 , 10 , 10 ) );
		p_north_north_south.add( btnReset );
		btnAbbruch.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				btnAbbruch_actionPerformed( e );
			}
		} );

		p_north_north_south.add( btnAbbruch );
		btnReset.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				reset_ActionPerformed( evt );
			}
		} );

		speichern.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				speichern_ActionPerformed( evt );
			}
		} );

		remove.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				remove_ActionPerformed( evt );
			}
		} );
		mntmffnen.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				btnOeffnen_ActionPerformed( evt );
			}
		} );
		mntmSpeichern.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				speichern_ActionPerformed( evt );
			}
		} );
		mntmBeenden.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				System.exit( 0 );
			}
		} );
		mntmHilfe.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent evt ) {

				mntmHilfe_ActionPerformed( evt );

			}
		} );
		btsuchen.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				btsuchen_ActionPerformed( e );

			}
		} );
		btubernehmen.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				btubernehmen_ActionPerformed( e );

			}
		} );
		btsuchereset.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				btsuchereset_ActionPerformed( e );

			}
		} );
		mntmAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				
				mntmAbout_ActionPerformed(evt);
			}
		});
	}

	protected void mntmAbout_ActionPerformed(ActionEvent evt) {
		JDialog jdabout = new JDialog(this, "About");
		JTextArea txaabout = new JTextArea();

		String strabout = "\n  Author : CLCarlie89 \n  Version: 2.0\n  Versiondate: 11.02.2020\n  Required Javaversion: 1.7      \n";

		txaabout.setEditable(false);
		txaabout.setText(strabout);

		jdabout.setLayout(new BorderLayout(10, 10));
		jdabout.add(new JLabel(" "), BorderLayout.NORTH);
		jdabout.add(new JLabel(" "), BorderLayout.WEST);

		jdabout.add(txaabout, BorderLayout.CENTER);

		jdabout.add(new JLabel(" "), BorderLayout.EAST);
		jdabout.add(new JLabel(" "), BorderLayout.SOUTH);

		jdabout.pack();
		jdabout.setVisible(true);
	}
	
	protected void btsuchereset_ActionPerformed( ActionEvent e ) {

		suche.setTextTextField( "" );
		model_suche.clear();

	}

	protected void btubernehmen_ActionPerformed( ActionEvent e ) {

		MyFile file = model.getFile( table.convertRowIndexToModel( table.getSelectedRow() ) );
		String filename = file.getName();
		suche.setTextTextField( filename );

	}

	protected void btsuchen_ActionPerformed( ActionEvent e ) {

		String suchtext = suche.getTextTextField();
		MyArrayList < MyFile > modeldata = model.getAll();
		MyArrayList < MyFile > modeldatanew = new MyArrayList < MyFile >();
		model_suche.clear();

		Collections.sort( modeldata );

		for ( int i = 0 ; i < modeldata.size() ; i++ ) {
			if ( modeldata.get( i ).getName().toLowerCase().contains( suchtext.toLowerCase() ) ) {
				modeldatanew.add( modeldata.get( i ) );
			}
		}
		model_suche.addFile( modeldatanew );
		tabbedPane.setSelectedIndex( 2 );
		remove.setEnabled( true );
	}

	protected void mntmHilfe_ActionPerformed( ActionEvent evt ) {

		Hilfe help = new Hilfe();

		// help.addListData(new HilfeData("Test1", new File("Hilfe.txt")));
		// help.addListData(new HilfeData("Test2", new File("Hilfe.txt"),
		// "Test2"));
		File file = new File( "hilfe" );
		File files[] = file.listFiles();
		for ( int i = 0 ; i < files.length ; i++ ) {
			help.addListData( new HilfeData( files[i] ) );
		}

		hilfe.getContentPane().add( help );
		Point point = this.getLocation();

		if ( this.getSize().width < Toolkit.getDefaultToolkit().getScreenSize().width ) {
			point.x = point.x + this.getWidth();
		}

		hilfe.setTitle( "Hilfe" );
		hilfe.setLocation( point );
		hilfe.setMinimumSize( new Dimension( 300 , 300 ) );
		hilfe.pack();
		hilfe.setVisible( true );

	}

	public void initGUI() {

		setMenu();

		getContentPane().setLayout( new BorderLayout( 10 , 10 ) );
		Arrays.sort( filterstrings );
		String tooltip = "Gibt die Ausnahmen fürs bearbeiten an.";

		getContentPane().add( tabbedPane_1 , BorderLayout.CENTER );

		tabbedPane_1.addTab( "Programm" , null , panel , null );
		panel.setLayout( new BorderLayout( 0 , 0 ) );
		panel.add( p_north , BorderLayout.NORTH );
		p_north.setLayout( new BorderLayout( 10 , 10 ) );

		p_north.add( p_north_north , BorderLayout.NORTH );
		p_north_north.setLayout( new BorderLayout( 10 , 10 ) );
		p_north_north.add( this.pfad , BorderLayout.CENTER );
		p_north_north.add( btnOeffnen , BorderLayout.WEST );
		p_north_north.add( btnStart , BorderLayout.EAST );

		p_north.add( p_north_center , BorderLayout.CENTER );
		p_north_center.setLayout( new BorderLayout( 10 , 10 ) );
		addcombo.getAddtolist().setEnabled( false );
		addcombo.getAddtolist().setVisible( false );
		addcombo.getRemove().setEnabled( false );
		addcombo.getRemove().setVisible( false );
		addcombo.addElement( filterlist );
		addcombo.addElement( filterstrings );
		addcombo.setToolTipTextComboBox( tooltip );
		addcombo.setToolTipText( tooltip );
		p_north_center.add( addcombo , BorderLayout.CENTER );

		p_north_north.setBorder( new TitledBorder( " " ) );

		p_north_north.add( p_north_north_south , BorderLayout.SOUTH );

		p_north.add( p_north_south , BorderLayout.SOUTH );
		p_north_south.setLayout( new GridLayout( 2 , 2 , 10 , 10 ) );
		p_north_south_1.setLayout( new GridLayout( 1 , 2 , 10 , 10 ) );
		p_north_south_1.setBorder( new TitledBorder( "" ) );
		p_north_south_2.setLayout( new GridLayout( 1 , 2 , 10 , 10 ) );
		p_north_south_2.setBorder( new TitledBorder( "" ) );

		rbtnutzen.setSelected( true );

		btgroup.add( rbtnutzen );
		rbtnutzen.setActionCommand( "nutzen" );
		btgroup.add( rbtignorienen );

		rbtignorienen.setSelected( true );
		rbtignorienen.setActionCommand( "ignorienen" );

		p_north_south_1.add( rbtnutzen );
		p_north_south_1.add( rbtignorienen );

		p_north_south_2.add( chbdateien );
		p_north_south_2.add( chbordner );

		p_north_south.add( p_north_south_1 );
		p_north_south.add( p_north_south_2 );
		p_north_south.add( speichern );
		p_north_south.add( remove );

		chbdateien.setToolTipText( "" );
		chbdateien.setSelected( true );
		chbordner.setToolTipText( "" );
		chbordner.setSelected( true );

		speichern.setEnabled( false );

		remove.setEnabled( false );
		panel.add( tabbedPane );
		tabbedPane.addTab( "Als Text" , jScrollPaneErgebnis );
		jScrollPaneErgebnis.setViewportView( ergebnis );

		tabbedPane.addTab( "Als Tabelle" , jscrollPaneTable );
		tabbedPane.addTab( "Suchergebnisse" , jScrollPaneSuche );

		table.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		table.setAutoCreateRowSorter( true );

		jscrollPaneTable.setViewportView( table );
		table_suche.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		table_suche.setAutoCreateRowSorter( true );

		jScrollPaneSuche.setViewportView( table_suche );

		p_south_south.setLayout( new GridLayout( 1 , 3 , 10 , 10 ) );
		btsuchen.setEnabled( false );
		p_south_south.add( btsuchen );
		btubernehmen.setEnabled( false );
		p_south_south.add( btubernehmen );
		btsuchereset.setEnabled( false );
		p_south_south.add( btsuchereset );

		p_south.setLayout( new BorderLayout( 10 , 10 ) );
		p_south.add( suche , BorderLayout.CENTER );
		p_south.add( p_south_south , BorderLayout.SOUTH );

		panel.add( p_south , BorderLayout.SOUTH );
		scrollPaneFehler.setViewportView( textAreaFehler );
		tabbedPane_1.addTab( "Fehler" , null , scrollPaneFehler , null );
		getContentPane().add( status , BorderLayout.SOUTH );

	}

	protected void btnOeffnen_ActionPerformed( ActionEvent evt ) {

		String fileAndDir = pfad.getText();
		JFileChooser file = new JFileChooser( fileAndDir );

		String[] fileEndings = { "txt" };
		FileFilter filefilter = new MyFileChooserFileFilter( fileEndings , true , "Textdatei " );
		file.setFileFilter( filefilter );
		file.addChoosableFileFilter( filefilter );

		filefilter = new TextFileFilter();
		file.addChoosableFileFilter( filefilter );

		file.setDialogType( JFileChooser.OPEN_DIALOG );
		file.setDialogTitle( "Datei \u00d6ffnen." );
		file.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );

		file.showOpenDialog( new JFrame() );

		fileAndDir = file.getSelectedFile().getAbsolutePath();

		pfad.setText( fileAndDir );
	}

	protected void remove_ActionPerformed( ActionEvent evt ) {

		MyFile file;
		int index = tabbedPane.getSelectedIndex();
		int row = 0;
		switch ( index) {
		case 1 :
			row = table.getSelectedRow();
			model.removeFile( table.convertRowIndexToModel( table.getSelectedRow() ) );
			model.fireTableDataChanged();
			if ( model.getRowCount() < 1 ) {
				remove.setEnabled( false );
			}
			table.addRowSelectionInterval( row , row );
			break;
		case 2 :
			row = table_suche.getSelectedRow();
			file = model_suche.getFile( table_suche.convertRowIndexToModel( row ) );
			model_suche.removeFile( table_suche.convertRowIndexToModel( row ) );
			model_suche.fireTableDataChanged();
			if ( model_suche.getRowCount() < 1 ) {
				remove.setEnabled( false );
			}

			table_suche.addRowSelectionInterval( row , row );
			int i = model.find( file );

			model.removeFile( i );
			model.fireTableDataChanged();

			if ( model_suche.getRowCount() < 1 ) {
				remove.setEnabled( false );
			}
			break;
		default :
			break;
		}
	}

	public void reset_ActionPerformed( ActionEvent evt ) {

		ergebnis.setText( "" );

		model.clear();
		model_suche.clear();

		speichern.setEnabled( false );
		remove.setEnabled( false );

		btsuchen.setEnabled( false );
		btubernehmen.setEnabled( false );
		btsuchereset.setEnabled( false );

	}

	@Override
	public void run() {

		btnStart.setEnabled( false );
		String textPfad = pfad.getText();
		List < String > lines = null;
		MyArrayList < MyFile > dateien = new MyArrayList < MyFile >();
		File file = new File( textPfad );
		StringBuilder sb = null;
		try {

			if ( file.isFile() ) {

				lines = readlines( file );
				for ( int i = 0 ; i < lines.size() ; i++ ) {

					if ( getThread().isInterrupted() ) {
						btnStart.setEnabled( true );
						break;
					}
					String marker = getMarker( lines.get( i ) );
					String text2;

					if ( lines.get( i ).contains( ";" ) ) {
						text2 = lines.get( i ).substring( 0 , lines.get( i ).lastIndexOf( ';' ) );
					} else {
						continue;
					}

					if ( marker.toUpperCase().equals( MyFile.FILE ) || marker.toUpperCase().equals( MyFile.DIRECTORY ) ) {
						System.out.println( "marker" + marker.toUpperCase() );

						dateien.add( new MyFile( marker.toUpperCase() , new File( text2 ) ) );
						System.out.println( dateien.get( dateien.size() - 1 ) );
					} else {
						System.out.println( "wrong marker" + marker.toUpperCase() );

						dateien.add( new MyFile( new File( text2 ) ) );

					}

				}
				dateien = filterdaten( dateien );

			} else {
				if ( file.isDirectory() ) {
					dateien = dateien_sammel( file );
					dateien = filterdaten( dateien );

				}
			}

			sb = new StringBuilder( dateien.size() );
			for ( int i = 0 ; i < dateien.size() ; i++ ) {

				sb.append( dateien.get( i ).getAbsolutePath() + "\n" );

			}

			status.setText( "Anzahl der Ordner und Dateien: " + dateien.size() );

			model.addFile( dateien );
			ergebnis.setText( ergebnis.getText() + sb.toString() + "\n\n" );

			// System.out.println(sb.toString());

		} catch ( Exception e ) {
			e.printStackTrace();
			StackTraceElement[] stack = e.getStackTrace();
			StringBuilder stackbuilder = new StringBuilder( stack.length );
			for ( int i = 0 ; i < stack.length ; i++ ) {
				stackbuilder.append( stack[i].toString() + "\n" );
			}
			textAreaFehler.setText( textAreaFehler.getText() + "\n" + e.getClass().toString() + "\n" + stackbuilder.toString() );
			ergebnis.setText( ergebnis.getText() + "Es ist ein Fehler aufgetretten siehe \"Fehler\"\n\n" );

		} finally {
			file = null;
			btnStart.setEnabled( true );
			speichern.setEnabled( true );
			remove.setEnabled( true );

			btsuchen.setEnabled( true );
			btubernehmen.setEnabled( true );
			btsuchereset.setEnabled( true );

			lines = null;
			dateien = null;
			textPfad = null;
			sb = null;
		}

	}

	public List < String > readlines( File file ) {

		// FileReader fr = null;
		// BufferedReader br = null;
		MyArrayList < String > liste = new MyArrayList < String >();

		try {
			liste.addAll( Files.readAllLines( file.toPath() , Charset.defaultCharset() ) );

			/*
			 * fr = new FileReader(file); br = new BufferedReader(fr); String text = ""; while ((text = br.readLine()) != null) {
			 * liste.add(text); }
			 */

		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
			StackTraceElement[] stack = e.getStackTrace();
			StringBuilder stackbuilder = new StringBuilder( stack.length );
			for ( int i = 0 ; i < stack.length ; i++ ) {
				stackbuilder.append( stack[i].toString() + "\n" );
			}
			textAreaFehler.setText( textAreaFehler.getText() + "\n" + e.getClass().toString() + "\n" + stackbuilder.toString() );
		} catch ( IOException e ) {
			e.printStackTrace();
			StackTraceElement[] stack = e.getStackTrace();
			StringBuilder stackbuilder = new StringBuilder( stack.length );
			for ( int i = 0 ; i < stack.length ; i++ ) {
				stackbuilder.append( stack[i].toString() + "\n" );
			}
			textAreaFehler.setText( textAreaFehler.getText() + "\n" + e.getClass().toString() + "\n" + stackbuilder.toString() );
		} finally {

			// br.close();
			// fr.close();

		}
		return liste;
	}

	public void setPosition() {

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = ( d.width - getSize().width ) / 2;
		int y = ( d.height - getSize().height ) / 2;
		setLocation( x , y );
	}

	protected void speichern_ActionPerformed( ActionEvent evt ) {

		String fileAndDir = "";
		if ( speicherpfad.length() <= 0 ) {
			fileAndDir = pfad.getText();
		} else {
			fileAndDir = speicherpfad;
		}

		JFileChooser filec = new JFileChooser( fileAndDir );

		String[] fileEndings = { "txt" };
		FileFilter filefilter = new MyFileChooserFileFilter( fileEndings , true , "Textdatei " );
		filec.setFileFilter( filefilter );
		filec.addChoosableFileFilter( filefilter );

		filefilter = new TextFileFilter();
		filec.addChoosableFileFilter( filefilter );

		filec.setDialogType( JFileChooser.OPEN_DIALOG );
		filec.setDialogTitle( "Datei �ffnen." );
		filec.setFileSelectionMode( JFileChooser.FILES_ONLY );

		filec.showSaveDialog( new JFrame() );

		fileAndDir = filec.getSelectedFile().getAbsolutePath();
		speicherpfad = fileAndDir;

		File file = new File( fileAndDir );
		PrintWriter pw = null;
		BufferedWriter bw = null;
		try {
			pw = new PrintWriter( file );
			bw = new BufferedWriter( pw );
			StringBuilder sb = null;
			MyArrayList < MyFile > files = model.getAll();
			String text = "";
			sb = new StringBuilder( files.size() );
			for ( int i = 0 ; i < files.size() ; i++ ) {

				sb.append( files.get( i ).toString() + "\n" );

			}
			text = sb.toString();
			bw.write( text );
			status.setText( "Erfolgreich gespeichert" );

		} catch ( FileNotFoundException e ) {
			status.setText( "Fehler beim Speichern : FileNotFound" );
			e.printStackTrace();
			StackTraceElement[] stack = e.getStackTrace();
			StringBuilder stackbuilder = new StringBuilder( stack.length );
			for ( int i = 0 ; i < stack.length ; i++ ) {
				stackbuilder.append( stack[i].toString() + "\n" );
			}
			textAreaFehler.setText( textAreaFehler.getText() + "\n" + e.getClass().toString() + "\n" + stackbuilder.toString() );

		} catch ( IOException e ) {
			status.setText( "Fehler beim Speichern : IO-Fehler" );
			e.printStackTrace();
			StackTraceElement[] stack = e.getStackTrace();
			StringBuilder stackbuilder = new StringBuilder( stack.length );
			for ( int i = 0 ; i < stack.length ; i++ ) {
				stackbuilder.append( stack[i].toString() + "\n" );
			}
			textAreaFehler.setText( textAreaFehler.getText() + "\n" + e.getClass().toString() + "\n" + stackbuilder.toString() );

		} catch ( NullPointerException e ) {
			status.setText( "Fehler beim Speichern : " + e.getClass().toString() );
			e.printStackTrace();
			StackTraceElement[] stack = e.getStackTrace();
			StringBuilder stackbuilder = new StringBuilder( stack.length );
			for ( int i = 0 ; i < stack.length ; i++ ) {
				stackbuilder.append( stack[i].toString() + "\n" );
			}
			textAreaFehler.setText( textAreaFehler.getText() + "\n" + e.getClass().toString() + "\n" + stackbuilder.toString() );
		} finally {

			try {
				bw.close();
			} catch ( IOException e ) {
				status.setText( "Fehler beim Speichern : " + e.getClass().getName() );
				e.printStackTrace();
				StackTraceElement[] stack = e.getStackTrace();
				StringBuilder stackbuilder = new StringBuilder( stack.length );
				for ( int i = 0 ; i < stack.length ; i++ ) {
					stackbuilder.append( stack[i].toString() + "\n" );
				}
				textAreaFehler.setText( textAreaFehler.getText() + "\n" + e.getClass().toString() + "\n" + stackbuilder.toString() );

			}
			pw.close();
			file = null;
		}

	}

	public void start_ActionPerformed( ActionEvent evt ) {

		getThread().start();
		thread = null;
	}

	protected void btnAbbruch_actionPerformed( ActionEvent e ) {

		getThread().interrupt();
	}
}
