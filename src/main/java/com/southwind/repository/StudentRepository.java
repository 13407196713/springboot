package com.southwind.repository;

import com.southwind.entity.Student;

import java.util.Collection;

public interface StudentRepository {

    public void saveorupdate(Student student);
    public void deleteById(long id);
    public Collection<Student> findAll();
    public Student findById(long id);

}
