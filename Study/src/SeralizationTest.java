import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class SeralizationTest implements java.io.Serializable{

	static File file = null;
	static FileInputStream fin = null;
	static FileOutputStream fout = null;
	static BufferedReader br = null;
	static PrintWriter pr = null;
	static String str = "";
	public static void main(String... ar)throws Exception {

		file = new File("F:/All.php");
		fin = new FileInputStream(file);
		fout =  new  FileOutputStream("C:/Documents and Settings/rita maa/Desktop/test2.ser");
        ObjectOutputStream out = new ObjectOutputStream(fout);
		br = new BufferedReader(new InputStreamReader(fin));
		String cpo = "";
		while ((str = br.readLine()) != null) {

			cpo = cpo + "\n" + str;
		}
		 out.writeObject(cpo);
		 out.close();
		 fout.close();
		System.out.println("done..");
	}
}
