import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PrintByPrinter implements Printable{
//	protected static final String NAME = "서버";
	private PrintWriter sout;
	private Socket socket;
	private static final String IP = "192.168.30.10";
	private static final int PORT_NUM = 9000;
	private Sortable sortable = new ScoreSort();
	
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
		ArrayList<Student> al = sortable.sort(printStudents);
		try {
			sout = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									socket.getOutputStream())));
			Iterator<Student> it = al.iterator();
			
			while(it.hasNext()) {
				Student st = it.next();
				sout.println(st);
			}
			sout.flush();
			sout.println("BYE");
			sout.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			}catch(Exception e) {}
		}
	}
}
