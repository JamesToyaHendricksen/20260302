package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "todo/form";
    }

    @PostMapping("/confirm")
    public String showConfirm(
            @RequestParam("title") String title,
            Model model) {
        model.addAttribute("title", title);
        return "todo/confirm";
    }

    @PostMapping("/complete")
    public String showComplete(
            @RequestParam("title") String title,
            Model model) {
        model.addAttribute("title", title);
        return "todo/complete";
    }

    public record TodoView(Long id, String title, String status) {
    }
}
