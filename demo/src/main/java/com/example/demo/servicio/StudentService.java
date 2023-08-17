package com.example.demo.servicio;

import java.util.Collection;

import com.example.demo.entidad.Student;

public interface StudentService {
    
    public Student SearchById(int id);

    public Collection<Student> SearchAll();

}
