package org.atao.tlias.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.atao.tlias.POJO.Clazz;
import org.atao.tlias.POJO.ClazzExt;

import java.util.List;

@Mapper
public interface ClazzsMapper {
    List<ClazzExt> getClazzs(String name, String begin, String end);

    @Delete("delete from clazz where id = #{id}")
    Integer deleteClazzs(Integer id);

    Integer addClazz(List<Clazz> clazzesList);

    List<Clazz> getClazzes(Clazz clazz);

    Integer setClazz(Clazz clazz);

    @Select("SELECT id, " +
            "name, " +
            "room, " +
            "begin_date, " +
            "end_date, " +
            "master_id, " +
            "subject, " +
            "create_time, " +
            "update_time " +
            "from tlias.clazz")
    List<Clazz> listClazzes();
}
