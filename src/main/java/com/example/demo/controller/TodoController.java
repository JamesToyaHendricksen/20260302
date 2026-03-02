package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public String list(Model model) {
        List<TodoView> todos = List.of(
                new TodoView(1L, "Learn Spring Boot", "OPEN"),
                new TodoView(2L, "Build ToDo list page", "IN_PROGRESS"),
                new TodoView(3L, "Adjust screen design", "DONE")
        );
        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @GetMapping("/new")
    public String showNewForm() {
        return "todo/new";
    }

    @GetMapping("/confirm")
    public String showConfirm() {
        return "todo/confirm";
    }

    public record TodoView(Long id, String title, String status) {
    }
}