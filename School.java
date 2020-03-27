import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class School
{
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
		
		
	}
}