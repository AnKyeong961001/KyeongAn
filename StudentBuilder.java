
public class StudentBuilder
{
	private static StudentBuilder studentBuilder;
	private String name;
	private String number;
	private String major;
	private int score;
	
	private StudentBuilder()
	{
		studentBuilder = null;
	}
	
	public static StudentBuilder getStudentBuilder()
	{
		if(studentBuilder == null)
		{
			studentBuilder = new StudentBuilder();
		}
		
		return studentBuilder;
	}
	
	public StudentBuilder setName(String name)
	{
		this.name = name;
		return this;
	}
	
	public StudentBuilder setNumber(String number)
	{
		this.number = number;
		return this;
	}
	
	public StudentBuilder setMajor(String major)
	{
		this.major = major;
		return this;
	}
	
	public StudentBuilder setScore(int score)
	{
		this.score = score;
		return this;
	}
	
	public Student build()
	{
		return new Student(name, number, major, score);
	}
}