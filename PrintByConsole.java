import java.util.Set;
import java.util.Iterator;

public class PrintByConsole implements Printable{

	@Override
	public void printStudent(Set<Student> printStudents) {
		try {
		System.out.println("* �ܼ� ����� �����մϴ� *");
		Iterator<Student> it=printStudents.iterator();
		while(it.hasNext())
		{
			Student student =it.next();
			System.out.println(student);
		}
		System.out.println("* �ܼ� ��� �Ϸ� *");
	}catch(NullPointerException e) {System.err.println("�����ϴ� �л��� �����ϴ�");}

}
}