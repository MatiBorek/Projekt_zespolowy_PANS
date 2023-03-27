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
    private KlientRepository teacherRepository;
    
    @Autowired
    private OperacjaRepository courseRepository;
    
    @Autowired
    private GraRepository studentRepository;

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
        Klient t1 = new Klient("Malinowski");
        Klient t2 = new Klient("Palka");
        Klient t3 = new Klient("Nowakowski");
                
        //Kursy
        Operacja c1 = new Operacja("Bazy danych",10);
        Operacja c2 = new Operacja("Programowanie w jezyku C",15);
        Operacja c3 = new Operacja("Hurtownie danych",20);
        Operacja c4 = new Operacja("Algorytmika",25);
        
        //Studenci
        Gra s1 = new Gra("Rumski",20);
        Gra s2 = new Gra("Franke",19);
        Gra s3 = new Gra("Malina",21);
        Gra s4 = new Gra("Ruszel",20);
        Gra s5 = new Gra("Abakowski",21);
        Gra s6 = new Gra("Portas",21);
        
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
        for (Klient teacher : teacherRepository.findAll())
        {
            System.out.println(teacher.toString());	
	}
        System.out.println("=====================================");
        
        System.out.println("Kursy...");
        for (Operacja course : courseRepository.findAll())
        {
            System.out.println(course.toString());	
	}
        System.out.println("=====================================");
        
        System.out.println("Studenci...");
        for (Gra student : studentRepository.findAll())
        {
            System.out.println(student.toString());	
	}
        System.out.println("=====================================");
        
        //============ ZLACZENIA ============================
        
        System.out.println("Kursy konkretnego nauczyciela...");
        String t = "Palka";
        for (Operacja course : courseRepository.findByTeacherName(t))
        {
            System.out.println(course.toString()+" prowadzi:"+t);	
	}
        System.out.println("=====================================");
        
        System.out.println("Kursy na ktore chodzi konretny student...");
        String s = "Portas";
        for (Operacja course : courseRepository.findByStudentsName(s))
        {
            System.out.println(course.toString()+" uczeszcza:"+s);	
	}
        System.out.println("=====================================");
        
        
        System.out.println("Studenci chodzacy na przedmiot...");
        String c = "Algorytmika";
        for (Gra student : studentRepository.findByCoursesSubject(c))
        {
            System.out.println(student.toString()+" uczeszcza na:"+c);	
	}
        System.out.println("=====================================");
        
        System.out.println("Studenci konkretnego nauczyciela...");
        t = "Palka";
        for (Gra student : studentRepository.findDistinctByCoursesTeacherName(t))
        {
            System.out.println(student.toString()+" ma nauczyciela:"+t);	
	}
        System.out.println("=====================================");
        
        
        System.out.println("Studenci chodzacy na ustalony przedmiot mlodsi od ustalonego wieku...");
        c = "Algorytmika";
        int a = 21;
        for (Gra student : studentRepository.findByAgeLessThanAndCoursesSubject(a,c))
        {
            System.out.println(student.toString()+" uczeszcza na kurs:"+c+" i jest mlodszy od "+a);	
	}
        System.out.println("=====================================");
        
        
        System.out.println("Nauczyciele prowadzacy konkretny kurs...");
        c = "Algorytmika";
        for (Klient teacher: teacherRepository.findByCoursesSubject(c))
        {
            System.out.println(teacher.toString()+" prowadzi kurs:"+c);	
	}
        System.out.println("=====================================");
        
        //============ USUWANIE ============================
        
        //Demonstracja usuwania nauczyciela
        
        String locTeacher = "Nowakowski";        
        List<Operacja> courseList = courseRepository.findByTeacherName(locTeacher);
        for (int i=0; i<courseList.size(); i++)
        {
            Operacja course = courseList.get(i);
            course.setTeacher(null);
            courseRepository.save(course);
        }
        
        List<Klient> teacherList = teacherRepository.findByName(locTeacher);
        Klient tt = teacherList.get(0);
        tt.clearCourses();
        teacherRepository.save(tt);
        teacherRepository.delete(tt);
                
        
        System.out.println("Nauczyciele po usunięciu...");
        for (Klient teacher : teacherRepository.findAll())
        {
            System.out.println(teacher.toString());	
	}
        System.out.println("=====================================");


    }
}

