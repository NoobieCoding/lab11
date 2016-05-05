package student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A student with a name, student id, and birthday.
 * 
 * @author jim (setBirthdate edited by Nuttapong Rojanavanich)
 */
public class Student {
	private String id;
	private String firstname, lastname;
	private LocalDate birthdate;

	/**
	 * Initialize attributes of a new student
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 */
	public Student(String id, String firstname, String lastname, String birthday) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		// date should be in the format "dd/MM/yyyy"
		setBirthdate(birthday);
	}

	/**
	 * Get the student's first name.
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Get the student's last name.
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Get the student's birth date.
	 * 
	 * @return the birthdate as a LocalDate instance.
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * Get the student's ID.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Set birth date of this student.
	 * If the argument is invalid print error message and throw exception.
	 * @param datestr is date to be set (in form of String)
	 */
	private void setBirthdate(String datestr) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			birthdate = LocalDate.parse(datestr, dateFormatter);
		} catch (Exception e) {
			System.out.println("Invalid date format");
			throw (e);
		}
	}

	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
}
