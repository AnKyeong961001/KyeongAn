import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class School
{
	private static final String STUDENT_NUM = "201\\d{1}\\\\d{4}";
	
	private Set<Student> students;
	private Printable printable;
	
	public School()
	{
		students = new TreeSet<Student>();
		printable = null;
	}
	
	// boolean�� ��ȯ�ϰ� �޴� ������ ������� ����ϰ� ��ȯ���� �����ؾ� �Ѵ�.
	//
	//
	public boolean addStudent(Student student)
	{
		return students.add(student);
	}
	
	public boolean removeStudent(String name)
	{
		Iterator<Student> is = students.iterator();
		
		while(is.hasNext())
		{
			Student student = is.next();
			if(student.getName().equals(name))
			{
				students.remove(student);
				System.out.println(name + "삭제완료");
				return true;
			}
		}
		
		System.out.println(name + " 삭제실패");
		return false;
	}
	
	public Set<Student> searchName(String name)
	{
		Set<Student> foundStudents = new TreeSet<>();
		Iterator<Student> is = students.iterator();
		
		while(is.hasNext())
		{
			Student student = is.next();
			if(student.getName().equals(name))
			{
				foundStudents.add(student);
			}
		}
		
		if(foundStudents.isEmpty())
		{
			return null;
		}
		else
		{
			return foundStudents;
		}
	}
	
	public Set<Student> searchMajor(String major)
	{
		Set<Student> foundStudents = new TreeSet<>();
		Iterator<Student> is = students.iterator();
		
		while(is.hasNext())
		{
			Student student = is.next();
			if(student.getMajor().equals(major))
			{
				foundStudents.add(student);
			}
		}
		
		if(foundStudents.isEmpty())
		{
			return null;
		}
		else
		{
			return foundStudents;
		}
	}
	
	public Set<Student> searchNumber(String number)
	{
		Set<Student> foundStudents = new TreeSet<>();
		Iterator<Student> is = students.iterator();
		
		while(is.hasNext())
		{
			Student student = is.next();
			if(student.getNumber().equals(number))
			{
				foundStudents.add(student);
			}
		}
		
		if(foundStudents.isEmpty())
		{
			return null;
		}
		else
		{
			return foundStudents;
		}
	}
	
	public Set<Student> getStudents()
	{
		return students;
	}
	
	public void setPrintable(String type)
	{
		switch(type)
		{
		case "서버":
			printable = new PrintByPrinter();
			System.out.println("��� ����� " + type +" 으로 설정되었습니다.");
			break;
		case "파일":
			printable = new PrintByFile();
			System.out.println("파일 ����� " + type +"���� �����Ǿ����ϴ�.");
			break;
		case "콘솔":
			printable = new PrintByConsole();
			System.out.println("콘솔 ����� " + type +"���� �����Ǿ����ϴ�.");
			break;
		default:
			System.out.println("�߸��� �Է� ����Դϴ�. �Է� : ������, ����, �ܼ�");
		}
	}
	
	public static void main(String[] args)
	{
		School school = new School();
		String name=null;
		BufferedReader out = new BufferedReader(new InputStreamReader(
				System.in));
		while(true) {
			System.out.println("이름:");
			try {
				name = out.readLine();
				break;
			}catch(Exception e) {
				System.out.println("다시 입력하세요.");
			}
		}
		while(true) {
			System.out.println("학번 : ");
			String id =null;
			try {
				id = out.readLine();
			}catch(Exception e) {System.out.println("다시 입력하세요.");}
			if(Pattern.matches(STUDENT_NUM,id)) {
				
			}
		}
	}
}
