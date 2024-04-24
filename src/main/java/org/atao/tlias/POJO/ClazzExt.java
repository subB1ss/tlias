package org.atao.tlias.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class ClazzExt extends Clazz {
    private String masterName; //班主任姓名
    private String status; //班级状态 - 未开班 , 在读 , 已结课
}
