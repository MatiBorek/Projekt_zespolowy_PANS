package joindemo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    private int age;
        
    @ManyToMany 
    private Set<Course> courses;

    protected Student() 
    {
        //courses = new HashSet<Course>();
    }

    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;     
        courses = new HashSet<Course>();
    }

    
    @Override
    public String toString() {
        return String.format(
                "Student[id=%d, name='%s', age='%d']",id, name, age);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    
    
    

}

