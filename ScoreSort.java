import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ScoreSort implements Sortable{
	public ArrayList<Student>sort(Set<Student> st){
		List<Student> studentList = new ArrayList<>(st);
		Collections.sort(studentList);
		return new ArrayList<>(studentList);
	}
}
