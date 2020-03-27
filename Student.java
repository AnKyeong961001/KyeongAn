
public class Student implements Comparable<Student>
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
	
	public String toString()
	{
		return "이름 : " + name + "/전공 : " + major + 
				" /학번 : " + number + " 점수 " + score + "점";
	}
	
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(!(getClass().getName().equals(o.getClass().getName()))) return false;
		
		Student obj = (Student)o;
		
		// 이름 검사
		if(name != null)
		{
			if(!(name.equals(obj.name))) return false;
		}
		else
		{
			if(obj.name != null) return false;
		}
		
		// 학번 검사
		if(number != null)
		{
			if(!(number.equals(obj.number))) return false;
		}
		else
		{
			if(obj.number != null) return false;
		}
		
		// 전공 검사
		if(major != null)
		{
			if(!(major.equals(obj.major))) return false; 
		}
		else
		{
			if(obj.major != null) return false;
		}
		// 점수 검사
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
	
	// 점수로 비교해서 출력
	public int compareTo(Student student)
	{
		return score - student.score;
	}
}
