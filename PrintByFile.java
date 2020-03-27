import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Set;

public class PrintByFile implements Printable{

	@Override
	public void printStudent(Set<Student> printStudents) {
		String path=null;
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("C:/javaTemp/data.txt"))));
			
			while(true)
			{
				try {	
					Iterator<Student> it =printStudents.iterator();
					while(it.hasNext()) {
					Student student = it.next();
					oos.writeObject(student);
					}
					oos.flush();
				}catch(EOFException e) {break;}
				catch(IOException e) {e.printStackTrace();}
			}
			
		   } catch (FileNotFoundException e) { e.printStackTrace();}
			 catch(IOException e) {e.printStackTrace();}
	
		
		
		try {
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
