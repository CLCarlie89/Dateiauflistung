package dateiauflistung;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class MyFile implements Comparable<MyFile>{

	static final String FILE = "FILE";
	static final String DIRECTORY = "DIRECTORY";

	private String typ;
	private File file;

	public MyFile(File file) {
		this.file = file;
	}

	public MyFile(String pathname) {
		file = new File(pathname);
		typ = FILE;
	}

	public MyFile(URI uri) {
		file = new File(uri);
		typ = FILE;
	}

	public MyFile(String parent, String child) {
		file = new File(parent, child);
		typ = FILE;
	}

	public MyFile(File parent, String child) {
		file = new File(parent, child);
		typ = FILE;
	}

	public MyFile(String typ, File file) {
		this.file = file;
		this.typ = typ;
	}

	public String getAbsolutePath() {

		return file.getAbsolutePath();
	}

	public String getName() {
		return file.getName();
	}

	public String getParent() {
		return file.getParent();
	}

	public String getPath() {
		return file.getPath();
	}

	public File getParentFile() {
		return file.getParentFile();
	}

	public String getCanonicalPath() throws IOException {
		return file.getCanonicalPath();
	}

	public File getAbsoluteFile() {
		return file.getAbsoluteFile();
	}

	public File getCanonicalFile() throws IOException {
		return file.getCanonicalFile();
	}

	/**
	 * @return the typ
	 */
	public String getTyp() {
		return typ;
	}

	/**
	 * @param typ
	 *            the typ to set
	 */
	public void setTyp(String typ) {
		this.typ = typ;
	}

	public boolean isFile() {
		if (getFile().exists()) {
			if (getFile().isFile()) {
				setTyp(FILE);
				return true;
			} else {
				setTyp(DIRECTORY);
				return false;
			}
		}
		if (getTyp().equals(FILE)) {
			return true;
		}

		return false;
	}

	public boolean isDirectory() {
		if (getFile().exists()) {
			if (getFile().isDirectory()) {
				setTyp(DIRECTORY);
				return true;
			} else {
				setTyp(FILE);
				return false;
			}
		}
		if (getTyp().equals(DIRECTORY)) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return file.getAbsolutePath() + ";" + typ;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (!(obj instanceof MyFile)) {
	        return false;
	    }

	    MyFile compare = (MyFile) obj;
		return this.getPath().equals(compare.getPath());
	}
	
	@Override
	public int compareTo(MyFile o) {
		return this.getPath().compareToIgnoreCase(o.getPath());
	}


	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}








	
	
}
