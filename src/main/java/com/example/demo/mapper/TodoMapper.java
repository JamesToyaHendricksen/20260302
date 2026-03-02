package com.example.demo.mapper;

import com.example.demo.model.Todo;

import java.util.List;

public interface TodoMapper {

    List<Todo> findAll();

    int insert(Todo todo);

    int deleteById(Long id);
}
