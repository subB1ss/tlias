package org.atao.tlias.service.clazzs;

import com.github.pagehelper.PageInfo;
import org.atao.tlias.POJO.Clazz;
import org.atao.tlias.POJO.ClazzExt;

import java.util.List;
import java.util.Map;


public interface ClazzsService {


    PageInfo<ClazzExt> getClazzs(String name, String begin, String end, Integer page, Integer pageSize);

    void deleteClazzs(Integer id);

    Integer addClazz(Clazz clazz);

    List<Clazz> getClazzes(Clazz clazz);

    List<Clazz> getClazzes();

    Integer setClazz(Clazz clazz);
}