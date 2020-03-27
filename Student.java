import java.io.Serializable;

public class Student implements Comparable<Student>,Serializable
{
	private static final long serialVersionUID = 1L;
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
	
	public String toString()
	{
		return "�̸� : " + name + "/���� : " + major + 
				" /�й� : " + number + " ���� " + score + "��";
	}
	
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(!(getClass().getName().equals(o.getClass().getName()))) return false;
		
		Student obj = (Student)o;
		
		// �̸� �˻�
		if(name != null)
		{
			if(!(name.equals(obj.name))) return false;
		}
		else
		{
			if(obj.name != null) return false;
		}
		
		// �й� �˻�
		if(number != null)
		{
			if(!(number.equals(obj.number))) return false;
		}
		else
		{
			if(obj.number != null) return false;
		}
		
		// ���� �˻�
		if(major != null)
		{
			if(!(major.equals(obj.major))) return false; 
		}
		else
		{
			if(obj.major != null) return false;
		}
		// ���� �˻�
		if(score != obj.score) return false;
		
		return true;
		
	}
	
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + number.hashCode();
		result = prime * result + major.hashCode();
		result = prime * result + score;
		
		return result;
	}
	
	// ������ ���ؼ� ���
	public int compareTo(Student student)
	{
		return - this.score + student.getScore();
	}
}
