package joindemo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    
    @OneToMany(mappedBy = "teacher") 
    private Set<Course> courses;

    protected Teacher() {
        //courses = new HashSet<Course>();
    }

    
    public Teacher(String name) {
        this.name = name;
        courses = new HashSet<Course>();
    }

    
    @Override
    public String toString() {
        return String.format(
                "Teacher[id=%d, name='%s']",id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    
    public void clearCourses() {
        courses = new HashSet<Course>();
    }
    

}

