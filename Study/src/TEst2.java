import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;


public class TEst2 {

	public static void main(String... atr) throws Exception  {

		FileInputStream fileIn = new FileInputStream("F:/Testing/1.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		FileInputStream fileIn2 = new FileInputStream("F:/Testing/2.ser");
		ObjectInputStream in2 = new ObjectInputStream(fileIn2);
		byte[] t= (byte[]) in.readObject();
		byte[] t2= (byte[]) in2.readObject();
		byte[] combined = new byte[t.length/2 + t2.length/2];

		System.arraycopy(t,0,combined,0         ,t.length/2);
		System.arraycopy(t2,0,combined,t.length/2,t2.length/2);
		System.out.println(combined.length);
		FileOutputStream fout = new FileOutputStream("F:/Testing/final.jpg");
		fout.write(combined);
		fout.close();
		
		
	}
	
}
