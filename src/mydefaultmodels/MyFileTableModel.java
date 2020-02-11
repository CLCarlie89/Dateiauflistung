package mydefaultmodels;

import java.io.File;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dateiauflistung.MyFile;

/*
 * Thema: LeVeTo
 * Name, Vorname: Liebsch,Carsten
 * Matrikelnummer: 292572
 * Fach: Programmierpraktikum, WS 12/13
 * Matrikel: IF09
 * Datum: 04.01.2013 <Datum letzter �nderung in dieser Datei>
 */
/**
 * Entwickelt aus dem BeispielTabelmodel von Herr Karsten Robel Tabellenmodell
 * zur Anwendung in der JTable, welches die Datenhaltung und das
 * View-Data-Mapping �bernimmt.
 * 
 * @version 20120502
 */
public class MyFileTableModel extends AbstractTableModel {
	/** nicht benutzt */
	private static final long serialVersionUID = 1L;
	/** Spaltenbezeichner */
	protected final static String[] COLUMN_NAMES = { "Datei", "Pfad", "Typ" };
	/** interner Datenspeicher (pro Zeile ein File) */
	private MyArrayList<MyFile> data = new MyArrayList<MyFile>();

	/** Anzahl Zeilen in der Tabelle. */
	@Override
	public int getRowCount() {
		return data.size();
	}

	/** Anzahl Spalten in der Tabelle. */
	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	/** [opt.] Name der angeforderten Spalte in der Tabelle. */
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	/** [opt.] Typ der Spalte */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class; // 0 "Datei" String
		case 1:
			return String.class; // 1 "Pfad" String

		default:
			return String.class;
		}

	}

	/**
	 * Mapping der Datenhaltung zur View (Welche Eigenschaft soll in welcher
	 * Spalte stehen?).
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		MyFile a = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			//if (a.isFile()) {
				return a.getFile().getName();
			//} else {
			//	return "";// 0 "File" String
			//}
		case 1:
			return a.getFile().getAbsolutePath();// 1 "Typ" String
		default:
			if (a.isFile()) {
				return getExtension(a.getFile());
			} else {
				return "";// 0 "File" String
			}

		}

	}

	public String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	/** [opt.] Soll die angegebene Zelle editierbar sein? */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// return columnIndex==1;
		return false;
	}

	/** So kann man File der Tabelle hinzufügen */
	public void addFile(MyFile ls) {
		data.add(ls);
		fireTableRowsInserted(data.size() - 1, data.size() - 1);
	}

	/** So kann man File der Tabelle hinzufügen */
	public void addFile(List<MyFile> ls) {
		int grosse = data.size();
		data.addAll(ls);

		fireTableRowsInserted(grosse, data.size() - 1);
	}

	
	
	/** So kann man File der Tabelle hinzufügen */
	public void addFile(MyFile[] ls) {
		int grosse = data.size();
		for (int i = 0; i < ls.length; i++) {
			data.add(ls[i]);
		}

		fireTableRowsInserted(grosse, data.size() - 1);
	}

	/** So kann man einen File aus der Tabelle entfernen */
	public void removeFile(int rowindex) {
		data.remove(rowindex);
	}

	/** so kann ein File konkret ermittelt werden. */
	public MyFile getFile(int rowIndex) {
		return data.get(rowIndex);
	}

	/** So kann man alle File aus der Tabelle entfernen */
	public void clear() {
		int grosse = data.size();
		if (grosse == 0) {
			return;
		}
		data.clear();
		fireTableRowsDeleted(0, grosse - 1);
	}

	public MyArrayList<MyFile> getAll() {
		return data;
	}

	public int find(MyFile file) {
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).equals(file)){
				return i;
			}
			
		}
		
		return -1;
	}

}
