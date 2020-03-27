import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class PrintByFile implements Printable{

	@Override
	public void printStudent(Set<Student> printStudents) {
		String path=null;
		BufferedWriter out = null;
		try {
			out=new BufferedWriter(new FileWriter("C:/javaTemp/data.txt"));
			
			while(true)
			{
				try {	
					Iterator<Student> it =printStudents.iterator();
					while(it.hasNext()) {
					Student student = it.next();
					StringTokenizer st=new StringTokenizer(student.toString(), "/");
					while(st.hasMoreTokens()) {
						String s = st.nextToken();
						out.write(s);
						out.flush();
					}
					}
					
				}catch(NullPointerException e) {System.err.println("존재하는 학생이 없습니다");}
				catch(EOFException e) {break;}
				catch(IOException e) {e.printStackTrace();}
			}
			
		   } catch (FileNotFoundException e) { e.printStackTrace();}
			 catch(IOException e) {e.printStackTrace();}
	
		
		
		try {
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
