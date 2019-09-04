package com.lizza.base_01.build_config.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-09-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;
    private Integer student_id;
    private String student_name;
}
