import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;

public class PrintByPrinter implements Printable{
//	protected static final String NAME = "서버";
	private PrintWriter sout;
	private Socket socket;
	private static final String IP = "192.168.30.10";
	private static final int PORT_NUM = 9000;
	
	public PrintByPrinter() {
		try {
			socket = new Socket(IP,PORT_NUM);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printStudent(Set<Student> printStudents) {
		if(printStudents == null) {
			System.out.println("존재하는 학생이 없습니다.");
			return;
		}
		try {
			sout = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									socket.getOutputStream())));
			Iterator<Student> it = printStudents.iterator();
			StringBuffer sb = new StringBuffer();
			while(it.hasNext()) {
				Student st = it.next();
				sb=sb.append(st.getName()).
						append(" ").
						append(st.getNumber()).
						append(" ").
						append(st.getMajor()).
						append(" ").
						append(st.getScore());
				sout.println(sb);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}
}
