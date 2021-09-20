package Model;

public class CourseRecord {
	public String title; //notice that string is not a primitive type
	int marks; //final raw marks out of 100
	public Faculty instructor;
	public CourseRecord() {
		//version 1: no attributes will be initialized using input values
		//Instead, each attribute will be initialized by its default value
		//int:0
		//double:0.0
		//boolean: false
		//reference type: null(no address)
		//note. if the attribute is of type string, if without being initialized, its default value is null
		
	}
	public CourseRecord(String title) {
		this.title=title;
		//only attribute is initialized with input 'title'
		//All other attributes (marks and instructor) will have their default values.
		
	}
	public CourseRecord(String title, int marks) {
		this.title=title;
		this.marks=marks;
		
	}
	public String getTitle() {
		return title;
	}
	public int getMarks() {
		return marks;
	}
	public Faculty getInstructor() {
		return instructor;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
public String getLetterGrade() {
	String lg="";
	if (this.marks>=90) {
		lg="A+";
	}
	else if (this.marks>=80) {
		lg="A";
	}
	else if (this.marks>=70) {
		lg="B";
	}
	else if (this.marks>=60) {
		lg="C";
		
	}
	else if (this.marks>=50) {
		lg="D";
		
	}
	else {
		lg="F"; 
	}
	return lg;
}
	public void setInstructor(Faculty instructor) {
		this.instructor = instructor;
	}
	public String getDescription() {
		String desc="";
		if (this.instructor==null) {
		desc= "Course "+ this.title +" (raw marks: "+ this.marks+ ") has no instructor";
		}
		else {
			desc= "Course "+ this.title +" (raw marks: "+ this.marks+ " letter grade "+this.getLetterGrade()+") has instructor ("+this.instructor.getDescription()+")";
		}
		return desc;
		}
}
