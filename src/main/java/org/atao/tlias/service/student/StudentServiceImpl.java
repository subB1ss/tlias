package org.atao.tlias.service.student;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.atao.tlias.POJO.Student;
import org.atao.tlias.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    StudentMapper studentMapper;
    @Override
    public Integer checkInterlink(Integer id) {
        return studentMapper.checkInterlink(id);
    }

    @Override
    public PageInfo<Student> getStudents(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize) {

//        PageHelper.startPage(page, pageSize);
//        studentMapper.getStudents();

//        return PageHelper.startPage(page, pageSize).doSelectPageInfo(() -> studentMapper.getStudents(name, degree, clazzId));

        return PageHelper.startPage(page, pageSize).doSelectPageInfo(
                () -> studentMapper.getStudentsByParam(name, degree, clazzId)
        );
    }

    @Override
    public List<Student> getStudents(Student student) {
        return studentMapper.getStudents(student);
    }

    @Override
    public Integer delStudent(Integer id) {
        return studentMapper.delStudent(id);
    }

    @Override
    public Integer addStudens(List<Student> students) {
        return studentMapper.addStudents(students);
    }

    @Override
    public Integer editStudent(Student student) {
        return studentMapper.editStudent(student);
    }
}
