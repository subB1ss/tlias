package org.atao.tlias.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.atao.tlias.POJO.Result;
import org.atao.tlias.POJO.Student;
import org.atao.tlias.service.student.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentsController {

    @Resource
    ApplicationContext ac;

    @Resource
    StudentService studentService;

    // todo: linked query with clazz table... 4/23/24 2:36 PM
    @GetMapping
    public Result getStudents(@RequestParam(required = false) String name,
                              @RequestParam(required = false) Integer degree,
                              @RequestParam(required = false) Integer clazzId,
                              @RequestParam Integer page,
                              @RequestParam Integer pageSize) {
        PageInfo<Student> pageInfo = studentService.getStudents(name, degree, clazzId, page, pageSize);
        if (pageInfo.getTotal() == 0)
            return Result.ret(0, "FAILED", null);

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("total", pageInfo.getTotal());
        retMap.put("rows", pageInfo.getList());
        return Result.ret(1, "SUCCEED", retMap);
    }

    @DeleteMapping("{id}")
    public Result delStudent(@PathVariable("id") Integer id) {
        if (! studentService.delStudent(id).equals(1))
            return Result.ret(0, "FAILED", null);

        return Result.ret(1, "SUCCEED", null);
    }


    //todo: exception handel... 4/23/24 2:31 PM
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        List<Student> students = new ArrayList<>();
        students.add(student);

        if(! studentService.addStudens(students).equals(1))
            return Result.ret(0, "FAILED", null);

        return Result.ret(1, "SUCCEED", null);
    }

    @GetMapping("{id}")
    public Result getStudentById(@PathVariable("id") Integer id) {
        Student student = ac.getBean("student", Student.class);
        student.setId(id);
        List<Student> students = studentService.getStudents(student);
        if (students.size() != 1)
            return Result.ret(0, "FAILED", null);
        return Result.ret(1, "SUCCEED", students.get(0));
    }

    @PutMapping
    public Result editStudent(@RequestBody Student student) {
        if (! studentService.editStudent(student).equals(1))
            return Result.ret(0, "FAILED", null);
        return Result.ret(1, "SUCCEED", null);
    }


    @PutMapping("/violation/{id}/{score}")
    public Result editStudent(@PathVariable Integer id, @PathVariable Short score) {
        Student student = ac.getBean("student", Student.class);
        student.setId(id);
        student.setViolationScore(score);
        if (! studentService.editStudent(student).equals(1))
            return Result.ret(0, "FAILED", null);
        return Result.ret(1, "SUCCEED", null);
    }


}
