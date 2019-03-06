package jbdc;
import java.io.File;
import java.io.FileOutputStream;

public class FileExample {
	static public void fun() {
		try {
			File f = new File("/Users/pdelac/Desktop/file/file");
			if(!f.exists()) {
			f.createNewFile();
			}
			
			//To write a file
//			FileWriter fWriter = new FileWriter(f);
//			fWriter.write("this is sample file ... :-)");
//			fWriter.flush();
//			fWriter.close();
			
			//To read a file
//			FileReader fReader = new FileReader(f);
//			int cnt = 0;
//			while (cnt < f.length()) {
//				System.out.println((char) fReader.read());
//				cnt++;
//			}
			
			FileOutputStream fileOutputStream = new FileOutputStream(f);
			String string = "........................Hello this is from fileOutputStream";
			fileOutputStream.write(string.getBytes());
			fileOutputStream.flush();
			
			System.out.println("File operation completed");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		FileExample.fun();
	}
}
