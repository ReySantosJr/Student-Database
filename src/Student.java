/**
 * Program Name: Iterator and Recursive Program
 * Program Purpose: 
 * A database that stores and manages student information. 
 * 
 * File Student.java
 * File Purpose: Contains methods for holding students and returning information.
 * 
 * @author Reynaldo Santos
 * @since 2018-13-12
 */

import java.util.*;

class Student {
    /*
     * Fields
     */
    private String name;
    private String major;
    private List<Course> list;

    /*
     * Constructor
     */
    public Student(String name, String major) {
	this.name = name;
	this.major = major;
	list = new ArrayList<Course>();
    }

    /*
     * Setters & Getters
     */
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getMajor() {
	return major;
    }

    public void setMajor(String major) {
	this.major = major;
    }

    /*
     * Other methods
     */
    public double getGPA() {
	int n = 0;
	double sum = 0;

	for (Course c : list) {
	    n += c.getCredit();
	    sum += c.getGrade() * c.getCredit();
	}

	if (n == 0) {
	    return 0;
	}

	else {
	    return sum / n;
	}
    }

    public void addCourse(double grade, int credits) {
	list.add(new Course(grade, credits));
    }

    public String toString() {
	StringBuilder s = new StringBuilder();
	s.append("Name of Student: ").append(name).append("\n");
	s.append("Major: ").append(major).append("\n");
	s.append("GPA: ").append(getGPA()).append("\n");

	return s.toString();
    }

}

class Course {
    /*
     * Fields
     */
    private double grade;
    private int credit;

    /*
     * Constructor
     */
    public Course(double grade, int credit) {
	setGrade(grade);
	setCredit(credit);
    }

    /*
     * Setters & Getters
     */
    public double getGrade() {
	return grade;
    }

    public void setGrade(double grade) {
	this.grade = grade;
    }

    public int getCredit() {
	return credit;
    }

    public void setCredit(int credit) {
	this.credit = credit;
    }

}
