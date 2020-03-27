import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class School
{
	private Set<Student> students;
	private static Printable printable;
	
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
				System.out.println(name + " ���� �Ϸ�");
				return true;
			}
		}
		
		System.out.println(name + " ���� ����");
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
		case "������":
			printable = new PrintByPrinter();
			System.out.println("��� ����� " + type +"���� �����Ǿ����ϴ�.");
			break;
		case "����":
			printable = new PrintByFile();
			System.out.println("��� ����� " + type +"���� �����Ǿ����ϴ�.");
			break;
		case "�ܼ�":
			printable = new PrintByConsole();
			System.out.println("��� ����� " + type +"���� �����Ǿ����ϴ�.");
			break;
		default:
			System.out.println("�߸��� �Է� ����Դϴ�. �Է� : ������, ����, �ܼ�");
		}
	}
	
	public static void main(String[] args)
	{
		School school = new School();	
		Student s1 = new Student("gildong", "1", "soft", 100);
		Student s2 = new Student("simchung", "2", "com", 90);
		Student s3 = new Student("ganggam", "3", "soft", 80);
		Student s4 = new Student("soonsin", "4", "com", 70);
		school.addStudent(s1);
		school.addStudent(s2);
		school.addStudent(s3);
		school.addStudent(s4);
		school.setPrintable("������");
		printable.printStudent(school.getStudents());
		school.setPrintable("����");
		printable.printStudent(school.getStudents());
		school.setPrintable("�ܼ�");
		printable.printStudent(school.getStudents());
	
		school.removeStudent("soonsin");
		school.setPrintable("������");
		printable.printStudent(school.getStudents());
		school.setPrintable("����");
		printable.printStudent(school.getStudents());
		school.setPrintable("�ܼ�");
		printable.printStudent(school.getStudents());	
		
		school.setPrintable("������");
		printable.printStudent(school.searchName("gildong"));
		school.setPrintable("����");
		printable.printStudent(school.searchName("gildong"));
		school.setPrintable("�ܼ�");
		printable.printStudent(school.searchName("gildong"));
		
		
		school.setPrintable("������");
		printable.printStudent(school.searchMajor("soft"));
		school.setPrintable("����");
		printable.printStudent(school.searchMajor("soft"));
		school.setPrintable("�ܼ�");
		printable.printStudent(school.searchMajor("soft"));
		
		
		school.setPrintable("������");
		printable.printStudent(school.searchNumber("2"));
		school.setPrintable("����");
		printable.printStudent(school.searchNumber("2"));
		school.setPrintable("�ܼ�");
		printable.printStudent(school.searchNumber("2"));
	}
}