import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class School
{
	private Set<Student> students;
	private static Printable printable;
	
	public School()
	{
		students = new HashSet<Student>();
		printable = null;
	}
	
	// boolean�� ��ȯ�ϰ� �޴� ������ ������� ����ϰ� ��ȯ���� �����ؾ� �Ѵ�.
	//
	//
	public boolean addStudent(Student student)
	{
		if(students.add(student))
		{
			System.out.println(student.getName() + " �߰� �Ϸ�");
			return true;
		}
		else
		{
			System.out.println(student.getName() + " �߰� ����");
			return false;
		}
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
		StudentBuilder studentBuilder = StudentBuilder.getStudentBuilder();

		School school = new School();	
		
		Student s1 = studentBuilder.setName("ȫ�浿").setNumber("20180243")
				.setMajor("���ڰ��а�").setScore(90).build();
		Student s2 = studentBuilder.setName("��켮").setNumber("20120853")
				.setMajor("ȯ����а�").setScore(50).build();
		Student s3 = studentBuilder.setName("�����").setNumber("20091502")
				.setMajor("��ǻ���а�").setScore(100).build();
		Student s4 = studentBuilder.setName("������").setNumber("20150432")
				.setMajor("�����а�").setScore(50).build();
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
	
		school.removeStudent("ȫ�浿");
		school.setPrintable("������");
		printable.printStudent(school.getStudents());
		school.setPrintable("����");
		printable.printStudent(school.getStudents());
		school.setPrintable("�ܼ�");
		printable.printStudent(school.getStudents());	
		
		school.setPrintable("������");
		printable.printStudent(school.searchName("��켮"));
		school.setPrintable("����");
		printable.printStudent(school.searchName("��켮"));
		school.setPrintable("�ܼ�");
		printable.printStudent(school.searchName("��켮"));
		
		
		school.setPrintable("������");
		printable.printStudent(school.searchMajor("�����а�"));
		school.setPrintable("����");
		printable.printStudent(school.searchMajor("�����а�"));
		school.setPrintable("�ܼ�");
		printable.printStudent(school.searchMajor("�����а�"));
		
		
		school.setPrintable("������");
		printable.printStudent(school.searchNumber("20091502"));
		school.setPrintable("����");
		printable.printStudent(school.searchNumber("20091502"));
		school.setPrintable("�ܼ�");
		printable.printStudent(school.searchNumber("20091502"));
		}
}
