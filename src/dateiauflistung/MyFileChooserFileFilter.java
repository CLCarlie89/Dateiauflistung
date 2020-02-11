package dateiauflistung;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFileChooserFileFilter extends FileFilter {

	private String[] filterstrings = {};
	private boolean allow = true;
	private String description = "Alle files";

	public MyFileChooserFileFilter(String descriptionname) {
		description=descriptionname;
	}

	public MyFileChooserFileFilter(String[] fileEndings,String descriptionname) {
		description=descriptionname;
		filterstrings = fileEndings;
	}

	public MyFileChooserFileFilter(boolean allowed,String descriptionname) {
		description=descriptionname;
		allow = allowed;
	}

	public MyFileChooserFileFilter(String[] fileEndings, boolean allowed,String descriptionname) {
		description=descriptionname;
		filterstrings = fileEndings;
		allow = allowed;
	}

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
		StringBuilder sb = new StringBuilder(filterstrings.length);
		
		for (int i = 0; i < filterstrings.length; i++) {
			sb.append("*." + filterstrings[i] + ",");
		}
		String str = sb.toString();
		String descrip = str.substring(0, str.length() - 1);

		return description + " : " + descrip;
	}

	protected boolean isAllow(boolean wert) {
		if (allow) {
			return wert;
		} else {
			return !wert;
		}
	}
}
