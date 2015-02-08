import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Test implements Serializable {

	public static void main(String... ar) throws IOException{
		
		Path path = Paths.get("F:/Testing/1.jpg");
		byte[] data = Files.readAllBytes(path);
		
		
		Path path2 = Paths.get("F:/Testing/2.jpg");
		byte[] data2 = Files.readAllBytes(path2);
		
	    FileOutputStream fout = new FileOutputStream("F:/Testing/1.ser");
	    ObjectOutputStream out = new ObjectOutputStream(fout);
	    
	    FileOutputStream fout1 = new FileOutputStream("F:/Testing/2.ser");
	    ObjectOutputStream out1 = new ObjectOutputStream(fout1);
	    
	    out.writeObject(data);
	    out.close();// 0400589340
	    
	    out1.writeObject(data2);
	    out1.close();
	    
	    System.out.println("done");
	}
	
}
