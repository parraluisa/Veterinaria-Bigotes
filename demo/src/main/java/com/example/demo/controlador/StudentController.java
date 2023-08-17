package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidad.Student;
import com.example.demo.servicio.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public String mostrarEstudiantes(Model model){
        model.addAttribute("estudiantes", studentService.SearchAll());

        return "mostrar_todos_estudiantes";
    }

        // http://localhost:8080/student/find?id=1
    @GetMapping("/find")
    public String mostrarInfoEstudiante(Model model, @RequestParam("id") int id) {

        Student student = studentService.SearchById(id);
        if (student != null) {
            model.addAttribute("persona", student);
        }

        return "mostrar_estudiante";
    }

    // http://localhost:8080/student/find/1
    @GetMapping("/find/{id}")
    public String mostrarInfoEstudiante2(Model model, @PathVariable("id") int id) {

        Student student = studentService.SearchById(id);
        if (student != null) {
            model.addAttribute("persona", student);
        }

        return "mostrar_estudiante";
    }

    
}
