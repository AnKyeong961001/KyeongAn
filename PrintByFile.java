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
		String path="C:/javaTemp/data.txt";
		BufferedWriter out = null;
		if(printStudents==null){System.err.println("존재하는 학생이 없습니다");}
		else {
					try {
						
						
							out=new BufferedWriter(new FileWriter(path));
							
							while(true)
							{
								try {	
									Iterator<Student> it =printStudents.iterator();
										while(it.hasNext()) {
										Student student = it.next();
										StringTokenizer st=new StringTokenizer(student.toString(), "/");
										int count=0;
										while(st.hasMoreTokens()) {
											if(count!=0)out.write(" / ");
											String s = st.nextToken();
											out.write(s);
											count++;
											}
										out.write("\n");
										out.flush();
										}
									}
									catch(IOException e) {e.printStackTrace();}
								break;
							}
					  }catch (FileNotFoundException e) { e.printStackTrace();}
					   catch(IOException e) {e.printStackTrace();}
				
					
					
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		    }
}}
