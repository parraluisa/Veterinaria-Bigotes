package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Student;

@Repository
public class StudentRepository {
    
    private Map<Integer, Student> data = new HashMap<>();
    
    public StudentRepository(){
        data.put(1, new Student("Sebastian Angarita", "Ingenieria en Sistemas", 3, "juseanto1@javeriana"));
        data.put(2, new Student("Pedro Angarita", "Ingenieria en Sistemas", 4, "juseant2o@javeriana"));
        data.put(3, new Student("Miguel Angarita", "Ingenieria en Sistemas", 5, "juseanto3@javeriana"));
        data.put(4, new Student("Mariano Angarita", "Ingenieria en Sistemas", 6, "juseanto4@javeriana"));
    }

    public Student findById(Integer id){
        return data.get(id);
    }

    public Collection<Student> findAll(){
        return data.values();
    }

}
