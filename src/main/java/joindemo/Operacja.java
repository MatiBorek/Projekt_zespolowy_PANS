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
public class Operacja {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String subject;
    private int hours;
    
    @ManyToOne 
    private Klient teacher;
    
    @ManyToMany 
    private Set<Gra> students;
    
    
    protected Operacja()
    {
        //teacher = null;
        //students = new HashSet<Student>();
    }

    
    public Operacja(String subject, int hours) {
        teacher = null;
        this.subject = subject;
        this.hours = hours;        
        students = new HashSet<Gra>();
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

    public Klient getTeacher() {
        return teacher;
    }

    public void setTeacher(Klient teacher) {
        this.teacher = teacher;
    }

    public Set<Gra> getStudents() {
        return students;
    }

    public void setStudents(Set<Gra> students) {
        this.students = students;
    }
    
    

}

