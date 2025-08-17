package com.example.demo.student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service // ✅ This registers it as a Spring bean
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
       return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent())
        {
           throw new IllegalStateException("email is taken");
        }
        else {
            studentRepository.save(student);
            System.out.println(
                    student+ " saved successfully"
            );
        }
    }
    @Transactional
    public void updateStudent(Long studentId,String name , String email)
    { Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student doesn't exist"));;

        student.setName(name);
        student.setEmail(email);


    }

    public void deleteStudent(long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
        throw new IllegalStateException("Student doesn't exist");
        }
    studentRepository.deleteById(studentId);
    }

}
