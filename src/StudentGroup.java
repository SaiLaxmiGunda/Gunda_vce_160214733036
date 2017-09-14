import java.util.ArrayList;
import java.util.Date;
import java.util.*;


/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	public Student[] getStudents() {
		// Add your implementation here
		
		return students;
	}

	public void setStudents(Student[] students) {
		// Add your implementation here
		try{
		if(students==null)
			throw new IllegalArgumentException();
		else 
			this.students=students;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
	}

	public Student getStudent(int index) {
		// Add your implementation here
		try{
			if(index>=0 && index<this.students.length)
				return this.students[index];
			else
				throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	public void setStudent(Student student, int index) {
		// Add your implementation here
		try{
			if(student==null || index<0 || index>=this.students.length)
				throw new IllegalArgumentException();
			else
				this.students[index]=student;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	public void addFirst(Student student) {
		// Add your implementation here
		try{
			if(student==null)
				throw new IllegalArgumentException();
			else
			{
				ArrayList<Student> mylist=new ArrayList<Student>();
				mylist.add(student);
				for(int i=0;i<students.length;i++)
				{
					mylist.add(this.students[i]);
				}
				this.students=(Student[]) mylist.toArray();
				
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	public void addLast(Student student) {
		// Add your implementation here
		try{
			if(student==null)
				throw new IllegalArgumentException();
			else
			{
				ArrayList<Student> mylist=new ArrayList<Student>();
				for(int i=0;i<students.length;i++)
				{
					mylist.add(this.students[i]);
				}
				mylist.add(student);
				this.students=(Student[]) mylist.toArray();
				
				
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	public void add(Student student, int index) {
		// Add your implementation here
		try{
			if(index<0|| index>=this.students.length || student==null)
				throw new IllegalArgumentException();
			else
			{
				Student temp=this.students[students.length-1];
				for(int i=students.length-1;i>index;i--)
				{
					students[i]=students[i-1];
				}
				students[index]=student;
				ArrayList<Student> mylist=new ArrayList<Student>();
				for(int i=0;i<students.length;i++)
				{
					mylist.add(this.students[i]);
				}
				mylist.add(temp);
				this.students=(Student[]) mylist.toArray();
				
			}
				
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	public void remove(int index) {
		// Add your implementation here
		try{
			if(index<0 || index>=students.length)
				throw new IllegalArgumentException();
			else
			{
				ArrayList<Student> mylist=new ArrayList<Student>();
				for(int i=0;i<index;i++)
					mylist.add(students[i]);
				for(int i=index+1;i<students.length;i++)
					mylist.add(students[i]);
				this.students=(Student[]) mylist.toArray();
				
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	public void remove(Student student) {
		// Add your implementation here
		int indx=-1;
		try{
			if(student==null)
				throw new IllegalArgumentException();
			else
			{
				for(int i=0;i<students.length;i++){
					if(students[i]==student){
						indx=i;break;}}
				if(indx==-1)
					throw new IllegalArgumentException("Student not exist");
				else
					this.remove(indx);
			}
			
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
	}

	public void removeFromIndex(int index) {
		// Add your implementation here
		try{
			if(index<0 || index>=students.length) throw new IllegalArgumentException();
			else
			{
				for(int i = index+1; i<=students.length; i++)
				{
					students[i] = null;
				}
			}
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
	}

	
	public void removeFromElement(Student student) {
		// Add your implementation here
		int index=-1;
		try{
			if(students == null) throw new IllegalArgumentException();
			else
			{
				for(int i=0; i<students.length; i++)
				{
					if(students[i].equals(student)) index=i;
				}
				if(index==-1) throw new IllegalArgumentException();
				else
				{
					for(int j=index+1; j<=students.length; j++)
						students[j]=null;
				}
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	public void removeToIndex(int index) {
		// Add your implementation here
		try{
			if(index<0 || index>=students.length)
				throw new IllegalArgumentException();
			else
			{
				ArrayList<Student> mylist=new ArrayList<Student>();
				for(int i=index;i<students.length;i++)
					mylist.add(students[i]);
				this.students=(Student[]) mylist.toArray();
				
				
				
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
	}

	public void removeToElement(Student student) {
		// Add your implementation here
		int ind= -1;
		try{
			if(student==null)
				throw new IllegalArgumentException();
			else
			{
				for(int i=0;i<students.length;i++){
					if(students[i]==student){
						ind=i;break;}}
				if(ind==-1)
					throw new IllegalArgumentException("Student not exist");
				else
					this.removeToIndex(ind);
			}
			
			
		}
		catch(IllegalArgumentException e)
		{
		   System.out.println(e);
		}
	}

	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			for(int j=0;j<students.length-i-1;j++)
			{
				if(students[j].getAvgMark()>students[j+1].getAvgMark())
				{
					double tmp1=students[j].getAvgMark();
					double tmp2=students[j+1].getAvgMark();
					students[j].setAvgMark(tmp2);
					students[j+1].setAvgMark(tmp1);
					
				}
			}
		}
	}

	
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		ArrayList<Student> mylist=new ArrayList<Student>();
		int cnt=0;
		try{
			if(date==null)
				throw new IllegalArgumentException();
			else
			{
				for(int i=0;i<students.length;i++)
				{
					if(date==students[i].getBirthDate())
						{mylist.add(students[i]);cnt++;}
					
				}
				Student st[]=new Student[cnt];
				st=(Student[])mylist.toArray();
				return st;
				
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
			return null;
		}
		//return null;
	}

	
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		Student[] studentarray=new Student[students.length];
		try{
		    int indx=0;
		    if(firstDate==null || lastDate ==null)
                throw new IllegalArgumentException();
            else{
                    for(int i=0;i<students.length;i++)
                    {

                        if(((students[i].getBirthDate().compareTo(firstDate))>=0)&&
                            ((students[i].getBirthDate().compareTo(lastDate))<=0))
                            studentarray[indx++]=students[i];
                    }
                    return studentarray;

            }
		}
		catch(Exception e)
		{
		    System.out.println(e);
		}

		return null;
	}


	
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		 long age = new Date().getTime() - students[indexOfStudent].getBirthDate().getTime();

		    return (int )age/(1000*60*60*24*365);
		
	}

	
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
      Student studarr[]=new Student[students.length];
      int indx=0;
      for(int i=0;i<students.length;i++)
      {
        long agemsec = new Date().getTime() - students[i].getBirthDate().getTime();
        int tempage=(int )agemsec/(1000*60*60*24*365);
        if(tempage==age)
          studarr[indx++]=students[i];
      }
      return studarr;
		
	}


	
	public Student[] getStudentsWithMaxAvgMark() {
	    try{
	        double max=students[0].getAvgMark();

		for(int i=1; i<students.length; i++)
		{
			if(students[i].getAvgMark()>max)
			{
				max=students[i].getAvgMark();
			}
		}
		Student maxstudents[] = new Student[students.length];
		int indx=0;
		for(int i=0; i<students.length; i++)
		{
			if(max == students[i].getAvgMark())
                {
                     maxstudents[indx++]=students[i];
            }
		}
		return maxstudents;

	    }
	    catch(Exception e)
	    {
	        System.out.println(e);

	    }
	    return null;

	}

	
	public Student getNextStudent(Student student) {
		// Add your implementation here
		int ind=-1;
		try{
			if(student==null)
				throw new IllegalArgumentException();
			else
			{
				for(int i=0;i<students.length;i++)
				{
					if(student==students[i])
						{ind=i;break;}
				}
				if(ind>=0 && ind<(students.length-1))
					return students[ind+1];
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
			return null;
		}
		return null;
		
		
	}
}
