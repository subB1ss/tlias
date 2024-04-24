package org.atao.tlias.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.atao.tlias.POJO.Clazz;
import org.atao.tlias.POJO.Clazz;
import org.atao.tlias.POJO.ClazzExt;
import org.atao.tlias.POJO.Result;
import org.atao.tlias.exceptions.IllegalOptException;
import org.atao.tlias.service.clazzs.ClazzsService;
import org.atao.tlias.service.student.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzsController {

    @Resource
    ApplicationContext ac;

    @Resource
    ClazzsService clazzsService;

    @Resource
    StudentService studentService;

//    private static Logger log = LoggerFactory.getLogger(ClazzsController.class);

    @GetMapping
//    @RequestMapping(method = RequestMethod.GET)
    public Result getClazzs(@RequestParam(required = false) String name,
                            @RequestParam(required = false) String begin,
                            @RequestParam(required = false) String end,
                            @RequestParam Integer page,
                            @RequestParam Integer pageSize) {
        log.debug("-----------------------------getClazzs(name, begin, end, page, pageSize):");
        log.debug("args: ");
        log.debug("name-------" + name);
        log.debug("begin-------" + begin);
        log.debug("end-------" + end);
        log.debug("page-------" + page);
        log.debug("pageSize-------" + pageSize);

        PageInfo<ClazzExt> pageInfo = clazzsService.getClazzs(name, begin, end, page, pageSize);
        log.debug("-------------------------------------------------------------DEBUG");
        log.debug(pageInfo.getList().toString());
        if (pageInfo.getTotal() == 0)
            return Result.ret(0, "FAILED", null);

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("total", pageInfo.getTotal());
        retMap.put("rows", pageInfo.getList());

        return Result.ret(1, "success", retMap);
//        return Result.ret(HttpCodeEnum.SUCCEED, "haha");
    }

    @DeleteMapping("{id}")
    public Result deleteClazzs(@PathVariable("id") Integer id) {
        log.debug("----------------------------deleteClazzs(id):");
        log.debug("args:");
        log.debug("id------" + id);
        if (!studentService.checkInterlink(id).equals(0))
            throw new IllegalOptException("班级关联学生未清空");
        clazzsService.deleteClazzs(id);
        log.debug("--------------------------test");
        return Result.ret(1, "SUCCEED", null);
    }

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        log.debug("---------------------------addClazzs(clazz)");
        log.debug("args:");
        log.debug("clazz------" + clazz);
        if (!clazzsService.addClazz(clazz).equals(1))
            return Result.ret(0, "FAILED", null);
        return Result.ret(1, "SUCCEED", null);
    }

    @GetMapping("{id}")
    public Result getClazzById(@PathVariable("id") Integer id) {
        log.debug("--------------------------getClazzById(id)");
        log.debug("args:");
        log.debug("id--------" + id);

        Clazz clazz = ac.getBean("clazz", Clazz.class);
        clazz.setId(id);
//        log.debug(clazz.toString());
        List<Clazz> clazzes = clazzsService.getClazzes(clazz);
        if (clazzes.size() != 1)
            return Result.ret(0, "FAILED", null);
        Clazz clazzProto = clazzes.get(0);
        return Result.ret(1, "SUCCEED", clazzProto);
    }

    @PutMapping
    public Result setClazz(@RequestBody Clazz clazz) {
        log.debug("--------------------------setClazz(clazz)");
        log.debug("args:");
        log.debug(clazz.toString());

        if( !clazzsService.setClazz(clazz).equals(1))
            return Result.ret(0, "FAILED", null);

        return Result.ret(1, "SUCCEED", null);
    }

    @GetMapping("/list")
    public Result getClazzesList() {
        log.debug("----------------------getClazzesList()");
        log.debug("args:");
        log.debug("null");

        return Result.ret(1, "SUCCEED", clazzsService.getClazzes());
    }
}
