import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class PrintByFile implements Printable {

	private Sortable sortable = new ScoreSort();
	
	@Override
	public void printStudent(Set<Student> printStudents) {
		
		String path = null;
		BufferedWriter out = null;
		ArrayList<Student> al = sortable.sort(printStudents);
		try {
			out = new BufferedWriter(new FileWriter("C:\\temp2\\data2.txt"));

			while (true) {
				try {
					Iterator<Student> it = al.iterator();
					while (it.hasNext()) {
						Student student = it.next();
						StringTokenizer st = new StringTokenizer(student.toString(), "/");
						// student �븯�굹 諛쏆븘
						while (st.hasMoreTokens()) {
							String s = st.nextToken();
							out.write(s); // 踰꾪띁�뿉 異붽�
							out.flush(); // �뜥吏��뒗嫄�
						}
					}
					break;
				} catch (NullPointerException e) {
					System.err.println("議댁옱�븯�뒗 �븰�깮�씠 �뾾�뒿�땲�떎");
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