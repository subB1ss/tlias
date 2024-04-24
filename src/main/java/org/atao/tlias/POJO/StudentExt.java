package org.atao.tlias.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExt extends Student{

    private String clazzName;//班级名称
}
