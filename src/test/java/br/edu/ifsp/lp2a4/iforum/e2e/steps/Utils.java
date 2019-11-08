package br.edu.ifsp.lp2a4.iforum.e2e.steps;

public class Utils {
	
	public static String GetUrlForPath(int port, String path) {
		return String.format("http://localhost:%d%s", port, path);
	}

}
