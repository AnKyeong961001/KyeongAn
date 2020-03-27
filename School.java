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
	
	// boolean을 반환하고 받는 곳에서 출력할지 출력하고 반환할지 결정해야 한다.
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
				System.out.println(name + " 삭제 완료");
				return true;
			}
		}
		
		System.out.println(name + " 삭제 실패");
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
		case "프린터":
			printable = new PrintByPrinter();
			System.out.println("출력 방식이 " + type +"으로 설정되었습니다.");
			break;
		case "파일":
			printable = new PrintByFile();
			System.out.println("출력 방식이 " + type +"으로 설정되었습니다.");
			break;
		case "콘솔":
			printable = new PrintByConsole();
			System.out.println("출력 방식이 " + type +"으로 설정되었습니다.");
			break;
		default:
			System.out.println("잘못된 입력 방식입니다. 입력 : 프린터, 파일, 콘솔");
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
		school.setPrintable("프린터");
		printable.printStudent(school.getStudents());
		school.setPrintable("파일");
		printable.printStudent(school.getStudents());
		school.setPrintable("콘솔");
		printable.printStudent(school.getStudents());
	
		school.removeStudent("soonsin");
		school.setPrintable("프린터");
		printable.printStudent(school.getStudents());
		school.setPrintable("파일");
		printable.printStudent(school.getStudents());
		school.setPrintable("콘솔");
		printable.printStudent(school.getStudents());	
		
		school.setPrintable("프린터");
		printable.printStudent(school.searchName("gildong"));
		school.setPrintable("파일");
		printable.printStudent(school.searchName("gildong"));
		school.setPrintable("콘솔");
		printable.printStudent(school.searchName("gildong"));
		
		
		school.setPrintable("프린터");
		printable.printStudent(school.searchMajor("soft"));
		school.setPrintable("파일");
		printable.printStudent(school.searchMajor("soft"));
		school.setPrintable("콘솔");
		printable.printStudent(school.searchMajor("soft"));
		
		
		school.setPrintable("프린터");
		printable.printStudent(school.searchNumber("2"));
		school.setPrintable("파일");
		printable.printStudent(school.searchNumber("2"));
		school.setPrintable("콘솔");
		printable.printStudent(school.searchNumber("2"));
	}
}