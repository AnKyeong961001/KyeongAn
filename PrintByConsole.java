import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

public class PrintByConsole implements Printable{

	private Sortable sortable = new ScoreSort();

	@Override
	public void printStudent(Set<Student> printStudents) {
		ArrayList<Student> al = sortable.sort(printStudents);

		try {
		System.out.println("* 콘솔 출력을 시작합니다 *");
		Iterator<Student> it=al.iterator();
		while(it.hasNext())
		{
			Student student =it.next();
			System.out.println(student);
		}
		System.out.println("* 콘솔 출력 완료 *");
	}catch(NullPointerException e) {System.err.println("존재하는 학생이 없습니다");}

}
}