package joindemo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String subject;
    private int hours;
    
    @ManyToOne 
    private Teacher teacher;
    
    @ManyToMany 
    private Set<Student> students;
    
    
    protected Course() 
    {
        //teacher = null;
        //students = new HashSet<Student>();
    }

    
    public Course(String subject, int hours) {
        teacher = null;
        this.subject = subject;
        this.hours = hours;        
        students = new HashSet<Student>();
    }


    
    @Override
    public String toString() {
        return String.format(
                "Course[id=%d, subject='%s', hours='%d']",id, subject, hours);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    

}

