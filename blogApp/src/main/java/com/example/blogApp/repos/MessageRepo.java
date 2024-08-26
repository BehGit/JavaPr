package com.example.blogApp.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.blogApp.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Integer>{
}
