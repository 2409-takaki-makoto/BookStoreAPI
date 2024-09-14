package com.example.BookStore.infra;

import org.apache.ibatis.annotations.Mapper;

import com.example.BookStore.domain.repository.BookRepository;

@Mapper
public interface BookMapper extends BookRepository {}
