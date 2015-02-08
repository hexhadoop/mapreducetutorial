import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Decode {
	public static void main(String... ar)throws Exception{
		FileInputStream fileIn = new FileInputStream("C:/Documents and Settings/rita maa/Desktop/test.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		String a = (String) in.readObject();
		System.out.println(a);
	}

}
