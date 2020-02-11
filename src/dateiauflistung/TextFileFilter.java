package dateiauflistung;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class TextFileFilter extends FileFilter {
	String filterstrings[] = { "txt", "rtf", "csv", "info" };

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = getExtension(f);
		if (extension != null) {
			if (filterstrings.length > 0) {
				for (int i = 0; i < filterstrings.length; i++) {
					if (extension.equals(filterstrings[i])) {
						return true;
					}
				}
				return false;
			}
			return true;

		}

		return false;

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

	@Override
	public String getDescription() {

		return "Textfiles : *.txt, *.rtf, *.csv, *.info";
	}

}
