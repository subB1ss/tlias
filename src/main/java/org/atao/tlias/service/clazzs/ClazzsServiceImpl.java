package org.atao.tlias.service.clazzs;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.atao.tlias.POJO.Clazz;
import org.atao.tlias.POJO.ClazzExt;
import org.atao.tlias.mapper.ClazzsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ClazzsServiceImpl implements ClazzsService{

    @Resource
    ClazzsMapper clazzsMapper;
    @Override
    public PageInfo<ClazzExt> getClazzs(String name, String begin, String end, Integer page, Integer pageSize) {

        return PageHelper.startPage(page, pageSize).doSelectPageInfo(
                () -> clazzsMapper.getClazzs(name, begin, end)
        );
    }

    @Override
    public void deleteClazzs(Integer id) {
        clazzsMapper.deleteClazzs(id).equals(1);
    }

    @Override
    public Integer addClazz(Clazz clazz) {
        ArrayList<Clazz> clazzesList = new ArrayList<>();
        clazzesList.add(clazz);
        return clazzsMapper.addClazz(clazzesList);
    }

    @Override
    public List<Clazz> getClazzes(Clazz clazz) {
        return clazzsMapper.getClazzes(clazz);
    }

    @Override
    public List<Clazz> getClazzes() {
        return clazzsMapper.listClazzes();
    }


    @Override
    public Integer setClazz(Clazz clazz) {
        return clazzsMapper.setClazz(clazz);
    }
}
