package org.atao.tlias.service.student;

import com.github.pagehelper.PageInfo;
import org.atao.tlias.POJO.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    Integer checkInterlink(Integer id);

    PageInfo<Student> getStudents(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize);

    List<Student> getStudents(Student student);

    Integer delStudent(Integer id);

    Integer addStudens(List<Student> students);

    Integer editStudent(Student student);
}
