
public class Student
{
	private String name;
	private String number;
	private String major;
	private int score;
	
	public Student(String name, String number, String major, int score)
	{
		this.name = name;
		this.number = number;
		this.major = major;
		this.score = score;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	public void setMajor(String major)
	{
		this.major = major;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public String getMajor()
	{
		return major;
	}
	
	public int getScore()
	{
		return score;
	}
}
