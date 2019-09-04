package com.lizza.base_01.build_config.dao;

import com.lizza.base_01.build_config.entity.Student;

public interface StudentMapper {
    int addOne(Student entity);
    Student findOneById(Integer id);
}
