package student;

import java.time.*;
import java.util.*;
import java.util.List;
import java.util.function.*;

/**
 * Display reminders of students having a birthday soon.
 * 
 * @author Nuttapong Rojanavanich
 */
public class StudentApp {

	static final int DAYS_IN_TWO_WEEKS = 14;

	/**
	 * Print the names (and birthdays) of students having a birthday in the
	 * specified month.
	 * 
	 * @param students is list of students
	 * @param month is the month to use in selecting birthdays
	 */
	public void filterAndPrint(List<Student> students, Predicate<Student> filter, Consumer<Student> action,
			Comparator<Student> compareMethod) {
		students.stream().filter(filter).sorted(compareMethod).forEach(action);
	}
	
	/**
	 * Main method used to find the students that will have their birth day soon.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		StudentApp app = new StudentApp();
		LocalDate today = LocalDate.now();

		Predicate<Student> nearBirthday = (st) -> (st.getBirthdate().getMonthValue() == today.getMonthValue());
		Predicate<Student> birthdayInTwoWeeks = (st) -> (st.getBirthdate().getDayOfYear() - today.getDayOfYear() >= 0)
				&& (st.getBirthdate().getDayOfYear() - today.getDayOfYear() <= DAYS_IN_TWO_WEEKS);
		
		Comparator<Student> byName = (a, b) -> a.toString().compareTo(b.toString());
		Comparator<Student> byBirthday = (a, b) -> a.getBirthdate().getDayOfYear() - b.getBirthdate().getDayOfYear();

		Consumer<Student> consumerForStudents = (st) -> {
			System.out.println(st.toString() + " will have birthday on " + st.getBirthdate().getDayOfMonth() + " "
					+ st.getBirthdate().getMonth().toString());
		};
		
		//app.filterAndPrint(students, nearBirthday, consumerForStudents, byBirthday);
		// students.sort(byName);
		// for(Student s: students){System.out.println(s.toString());}
		app.filterAndPrint(students, birthdayInTwoWeeks, consumerForStudents, byBirthday);
	}
}
