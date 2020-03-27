import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class PrintByFile implements Printable {

	@Override
	public void printStudent(Set<Student> printStudents) {
		
		String path = null;
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("/Users/jeonkyeong-an/temp/data3.txt"));

			while (true) {
				try {
					Iterator<Student> it = printStudents.iterator();
					while (it.hasNext()) {
						Student student = it.next();
						StringTokenizer st = new StringTokenizer(student.toString(), "/");
						// student 하나 받아
						while (st.hasMoreTokens()) {
							String s = st.nextToken();
							out.write(s); // 버퍼에 추가
							out.flush(); // 써지는거
						}
					}
					break;
				} catch (NullPointerException e) {
					System.err.println("존재하는 학생이 없습니다");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}