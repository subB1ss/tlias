package org.atao.tlias.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.atao.tlias.POJO.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT COUNT(0) FROM student WHERE clazz_id = #{id}")
    Integer checkInterlink(Integer id);


    List<Student> getStudentsByParam(String name, Integer degree, Integer clazzId);

    @Delete("DELETE FROM student WHERE id = #{id}")
    Integer delStudent(Integer id);

    Integer addStudents(List<Student> students);

    // only implement select by id now
    List<Student> getStudents(Student student);

    Integer editStudent(Student student);
}
