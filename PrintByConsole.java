import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

public class PrintByConsole implements Printable{

	private Sortable sortable = new ScoreSort();

	@Override
	public void printStudent(Set<Student> printStudents) {
		ArrayList<Student> al = sortable.sort(printStudents);

		try {
		System.out.println("* �ܼ� ����� �����մϴ� *");
		Iterator<Student> it=al.iterator();
		while(it.hasNext())
		{
			Student student =it.next();
			System.out.println(student);
		}
		System.out.println("* �ܼ� ��� �Ϸ� *");
	}catch(NullPointerException e) {System.err.println("�����ϴ� �л��� �����ϴ�");}

}
}