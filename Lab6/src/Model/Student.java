package Model;

public class Student {

	public String name;
	final int MAX_NUM_COURSES=5;
	public CourseRecord[] courses;
	//1. value of noc represents the number of course record objects stored in the course record array
	//2. value of noc denotes where in the array 'courses' is the next course record object to be stored.
	
	int noc;
	public Student(String name) {
		this.name=name;
		this.courses=new CourseRecord[MAX_NUM_COURSES];
		this.noc=0;
	}
	
	//version 1
	public void addCourse(CourseRecord c) {
		this.courses[this.noc]=c;
		this.noc++;
		
	}
	//version 2
	public void addCourse(String title) {
		CourseRecord c= new CourseRecord(title);
		this.addCourse(c);
//		this.courses[this.noc]=c;
//		this.noc++;
	}
	/*
	 *given the title of the course return the marks of that course
	 *If the course does not exist, return -1
	 *
	 */
	public int getMarks(String title) {
		int marks=-1;
		int index= this.indexOf(title);
		if (index>=0) {
			marks = this.courses[index].getMarks();
		}
		return marks;
		
	}
	
	/*
	 *given the title of the course set the marks of that course
	 *If the course does not exist,  do nothing
	 *
	 */
	public void setMarks(String title, int marks) {
		int index = this.indexOf(title);
		if(index>=0) {
			
			this.courses[index].setMarks(marks);
		}
	}
	
	 //Helper method reused by getMarks and setMarks
	//Given the title of course return the  index of the corresponding course object
	// if the title does not exist return -1 as the index
	public int indexOf(String title) {
		
		int index =-1;
		boolean found = false;
		for (int i=0; i<this.noc&& !found;i++) {
			if (this.courses[i].getTitle().equals(title)) {
				found = true;
				index=i;
			}
		}
		return index;
		
	}
	public double getGPA() {
		double gpa =0.0;
		double gp=0.0;
		for (int i=0; i<this.noc;i++) {
			String lg=this.courses[i].getLetterGrade();
			if (lg.equals("A+")) {
				gp+=9;
			}
			else if (lg.contentEquals("A")) {
				gp+=8;
			}
			else if (lg.contentEquals("B")) {
				gp+=7;
			}
			else if (lg.contentEquals("C")) {
				gp+=6;
			}
			else if (lg.contentEquals("D")) {
				gp+=5;
			}
			else {
				gp+=0;
			}
		}
		if (this.noc==0) {
			gpa=0.0;
		}
		else {
		gpa=gp/this.noc;
		}
		return gpa;
	}
	public String getDescription() {
		String result ="";
		result+="Student "+this.name+ " has registered "+this.noc +" courses (with GPA "+this.getGPA()+  "):  \n";
		for (int i=0;i<this.noc;i++) {
			result += this.courses[i].getDescription()+ "\n";
		}
		return result;
	}
	
	
}
