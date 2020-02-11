package dateiauflistung;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

	private String filterstringlist[] = {};
	private boolean nutzen = true;

	public MyFileFilter() {

	}

	public MyFileFilter(String fileEndings) {
		setFilter(fileEndings, ",");
	}

	public MyFileFilter(String[] fileEndings) {
		filterstringlist = fileEndings;
	}

	public MyFileFilter(boolean allowed) {
		nutzen = allowed;
	}

	public MyFileFilter(String fileEndings, boolean nutzen) {
		setFilter(fileEndings, ",");
		this.nutzen = nutzen;
	}

	public MyFileFilter(String[] fileEndings, boolean allowed) {
		filterstringlist = fileEndings;
		nutzen = allowed;
	}

	public MyFileFilter(String fileEndings, String split) {
		setFilter(fileEndings, split);
	}

	public MyFileFilter(String fileEndings, String split, boolean nutzen) {
		setFilter(fileEndings, split);
		this.nutzen = nutzen;
	}

	@Override
	public boolean accept(File f) {

		if (f.isDirectory()) {
			return true;
		}

		if (filterstringlist != null) {

			String extension = getExtension(f);

			if (nutzen == false) {
				if (extension != null) {
					for (int i = 0; i < filterstringlist.length; i++) {
						if (extension.equals(filterstringlist[i])) {
							return false;
						}
					}
					return true;
				}
				return false;
			} else {
				if (nutzen == true) {
					if (extension != null) {
						for (int i = 0; i < filterstringlist.length; i++) {
							if (extension.equals(filterstringlist[i])) {
								return true;
							}
						}
						return false;
					}
					return false;
				}
				return false;
			}
		}
		return true;
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

	public void setFilter(String text1, String split) {
		String text = text1;
		text = trimm(text);
		if (text.length() > 0) {
			filterstringlist = text.split(split);
		} else {
			filterstringlist = null;
		}

	}

	public String trimm(String text) {
		String text2 = "";

		for (int i = 0; i < text.length(); i++) {
			char t = text.charAt(i);
			if (t != ' ') {
				text2 = text2 + t;
			}
		}

		return text2;
	}
}
