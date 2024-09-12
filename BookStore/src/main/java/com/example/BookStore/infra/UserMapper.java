package com.example.BookStore.infra;

import org.apache.ibatis.annotations.Mapper;

import com.example.BookStore.domain.repository.UserRepository;

@Mapper
public interface UserMapper extends UserRepository {}
