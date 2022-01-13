import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class Base64er {
	public static void main(String[] args) throws Throwable {
		File file = new File("E:/JitWorkSpace/gatewa-vue/target/test-classes/Hacker.class");
		byte[] cls = new byte[(int) file.length()];
		try (FileInputStream r = new FileInputStream(file)) {
			r.read(cls);
		} catch (Throwable t) {
			t.printStackTrace();
		}

		String clazz = Base64.getEncoder().encodeToString(cls);
		System.out.println(clazz);
	}

}
