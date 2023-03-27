package joindemo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCoursesSubject(String subject);
    
    List<Student> findByAgeLessThanAndCoursesSubject(int age,String subject);
    
    List<Student> findDistinctByCoursesTeacherName(String name);
    
    //LISTA OPERATOROW DO TWORZENIA ZAPYTAN
/*
IsAfter, After, IsGreaterThan, GreaterThan;
IsGreaterThanEqual, GreaterThanEqual;
IsBefore, Before, IsLessThan, LessThan;
IsLessThanEqual, LessThanEqual;
IsBetween, Between;
IsNull, Null;
IsNotNull, NotNull;
IsIn, In;
IsNotIn, NotIn;
IsStartingWith, StartingWith, StartsWith;
IsEndingWith, EndingWith, EndsWith;
IsContaining, Containing, Contains;
IsLike, Like;
IsNotLike, NotLike;
IsTrue, True;
IsFalse, False;
Is, Equals;
IsNot, Not;
And, Or
OrderBy
*/

}
