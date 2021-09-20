package Model;

public class StudentManagementSystem {
	public String Sname;
	final int MAX_NUM_STUDENTS=100;
	public Student[] stud;
	
	int nos;
	public StudentManagementSystem() {
		//this.Sname=Sname;
		this.stud=new Student[MAX_NUM_STUDENTS];
		this.nos=0;
	}
	public String getDescription() {
		String result ="";
		result="Student management system currently stores ";
		if (this.nos==0) {
			result+= "no students.";
		}
		else {
			result+=this.nos+" students: \n";
		for (int i=0;i<this.nos;i++) {
			result += this.stud[i].getDescription()+ "\n";
		}
		
		}
		return result;
	}
	
	public Student[] getStudents() {
		
		Student[] St= new Student[nos];
		for (int i =0; i<nos;i++) {
			St[i]=stud[i];
		}
		return St;
	}
	
	public void addStudent(Student S) {
		this.stud[nos]=S;
		this.nos++;
		
	}
	public void addStudent(String Sn) {
		this.stud[nos]=new Student(Sn);
		this.nos++;
	}
	public void addCourse(String Sn, CourseRecord C) {
		int ind = SindexOf(Sn);
		stud[ind].courses[stud[ind].noc]=C;
		stud[ind].noc++;
	}	
	public int getMarks(String Student, String title) {
	
		int marks=-1;
		int index= this.SindexOf(Student);
		if (index>=0) {
			marks = this.stud[index].getMarks(title);
		}
		return marks;
		
	}
	public void setMarks(String Student, String course, int marks ) {
		
		int index= this.SindexOf(Student);
		if (index>=0) {
			this.stud[index].setMarks(course, marks);
		}
		
	}
	public int SindexOf(String Student) {
		
		int Sindex =-1;
		
		boolean found = false;
		for (int i=0; i<this.nos&& !found;i++) {
			if (this.stud[i].name.equals(Student)) {
				found = true;
				Sindex=i;
			}
		}
		return Sindex;
	
	
}

public double getGPA(String Student){
	
	return stud[SindexOf(Student)].getGPA();
}


}

