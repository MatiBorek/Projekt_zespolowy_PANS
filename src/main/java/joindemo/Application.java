package joindemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 @SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) {
              
        //OPIS DANYCH
        //Nauczyciele: 
        //  T1. Malinowski prowadzi kurs: C2
        //  T2. Palka prowadzi kurs C1 i C2
        //  T3. Nowakowski prowadzi kurs C4
        
        //Kursy: C1, C2, C3 i C4
        //Studenci: S1, S2, S3, S4, S5, S6
        
        //Studenci i kursy
        /*
          |C1|C2|C3|C4
        S1|xx|  |xx|  | 
        S2|xx|  |  |  | 
        S3|xx|xx|xx|  | 
        S4|  |xx|  |xx| 
        S5|  |xx|xx|xx| 
        S6|xx|  |xx|xx| 
        */
        
        
        //Nauczyciele
        Teacher t1 = new Teacher("Malinowski");
        Teacher t2 = new Teacher("Palka");
        Teacher t3 = new Teacher("Nowakowski");
                
        //Kursy
        Course c1 = new Course("Bazy danych",10);
        Course c2 = new Course("Programowanie w jezyku C",15);
        Course c3 = new Course("Hurtownie danych",20);
        Course c4 = new Course("Algorytmika",25);
        
        //Studenci
        Student s1 = new Student("Rumski",20);
        Student s2 = new Student("Franke",19);
        Student s3 = new Student("Malina",21);
        Student s4 = new Student("Ruszel",20);
        Student s5 = new Student("Abakowski",21);
        Student s6 = new Student("Portas",21);
        
        //===============================================
        //Wstepne wstawienie jeszcze bez powiazan
        
        teacherRepository.save(t1);
        teacherRepository.save(t2);
        teacherRepository.save(t3);
        
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
        studentRepository.save(s4);
        studentRepository.save(s5);
        studentRepository.save(s6);
        
        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);
        courseRepository.save(c4);
        
        //===============================================
        
        //Przypisanie kursow do nauczycieli
        t1.getCourses().add(c2);
        t2.getCourses().add(c1);
        t2.getCourses().add(c3);
        t3.getCourses().add(c4);
        
        //Przypisanie nauczycieli do kursow
        c1.setTeacher(t2);
        c2.setTeacher(t1);
        c3.setTeacher(t2);
        c4.setTeacher(t3);
        
        //Przypisanie kursow do studentow
        s1.getCourses().add(c1);
        s1.getCourses().add(c3);        
        s2.getCourses().add(c1);        
        s3.getCourses().add(c1);
        s3.getCourses().add(c2);
        s3.getCourses().add(c3);        
        s4.getCourses().add(c2);
        s4.getCourses().add(c4);        
        s5.getCourses().add(c2);
        s5.getCourses().add(c3);
        s5.getCourses().add(c4);        
        s6.getCourses().add(c1);
        s6.getCourses().add(c3);
        s6.getCourses().add(c4);
        
        //Przypisanie studentow do kursow
        c1.getStudents().add(s1);
        c1.getStudents().add(s2);
        c1.getStudents().add(s3);
        c1.getStudents().add(s6);        
        c2.getStudents().add(s3);
        c2.getStudents().add(s4);
        c2.getStudents().add(s5);        
        c3.getStudents().add(s1);
        c3.getStudents().add(s3);
        c3.getStudents().add(s5);
        c3.getStudents().add(s6);        
        c4.getStudents().add(s4);
        c4.getStudents().add(s5);
        c4.getStudents().add(s6);
                
        //===============================================
        
        //Dodanie powiazan        
        
        teacherRepository.save(t1);
        teacherRepository.save(t2);
        teacherRepository.save(t3);
        
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
        studentRepository.save(s4);
        studentRepository.save(s5);
        studentRepository.save(s6);
        
        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);
        courseRepository.save(c4);
                
        //===============================================
                                
        System.out.println("Nauczyciele...");
        for (Teacher teacher : teacherRepository.findAll()) 
        {
            System.out.println(teacher.toString());	
	}
        System.out.println("=====================================");
        
        System.out.println("Kursy...");
        for (Course course : courseRepository.findAll()) 
        {
            System.out.println(course.toString());	
	}
        System.out.println("=====================================");
        
        System.out.println("Studenci...");
        for (Student student : studentRepository.findAll()) 
        {
            System.out.println(student.toString());	
	}
        System.out.println("=====================================");
        
        //============ ZLACZENIA ============================
        
        System.out.println("Kursy konkretnego nauczyciela...");
        String t = "Palka";
        for (Course course : courseRepository.findByTeacherName(t)) 
        {
            System.out.println(course.toString()+" prowadzi:"+t);	
	}
        System.out.println("=====================================");
        
        System.out.println("Kursy na ktore chodzi konretny student...");
        String s = "Portas";
        for (Course course : courseRepository.findByStudentsName(s)) 
        {
            System.out.println(course.toString()+" uczeszcza:"+s);	
	}
        System.out.println("=====================================");
        
        
        System.out.println("Studenci chodzacy na przedmiot...");
        String c = "Algorytmika";
        for (Student student : studentRepository.findByCoursesSubject(c)) 
        {
            System.out.println(student.toString()+" uczeszcza na:"+c);	
	}
        System.out.println("=====================================");
        
        System.out.println("Studenci konkretnego nauczyciela...");
        t = "Palka";
        for (Student student : studentRepository.findDistinctByCoursesTeacherName(t)) 
        {
            System.out.println(student.toString()+" ma nauczyciela:"+t);	
	}
        System.out.println("=====================================");
        
        
        System.out.println("Studenci chodzacy na ustalony przedmiot mlodsi od ustalonego wieku...");
        c = "Algorytmika";
        int a = 21;
        for (Student student : studentRepository.findByAgeLessThanAndCoursesSubject(a,c)) 
        {
            System.out.println(student.toString()+" uczeszcza na kurs:"+c+" i jest mlodszy od "+a);	
	}
        System.out.println("=====================================");
        
        
        System.out.println("Nauczyciele prowadzacy konkretny kurs...");
        c = "Algorytmika";
        for (Teacher teacher: teacherRepository.findByCoursesSubject(c)) 
        {
            System.out.println(teacher.toString()+" prowadzi kurs:"+c);	
	}
        System.out.println("=====================================");
        
        //============ USUWANIE ============================
        
        //Demonstracja usuwania nauczyciela
        
        String locTeacher = "Nowakowski";        
        List<Course> courseList = courseRepository.findByTeacherName(locTeacher);
        for (int i=0; i<courseList.size(); i++)
        {
            Course course = courseList.get(i);
            course.setTeacher(null);
            courseRepository.save(course);
        }
        
        List<Teacher> teacherList = teacherRepository.findByName(locTeacher);                       
        Teacher tt = teacherList.get(0);
        tt.clearCourses();
        teacherRepository.save(tt);
        teacherRepository.delete(tt);
                
        
        System.out.println("Nauczyciele po usunięciu...");
        for (Teacher teacher : teacherRepository.findAll()) 
        {
            System.out.println(teacher.toString());	
	}
        System.out.println("=====================================");


    }
}

