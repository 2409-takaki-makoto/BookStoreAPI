package com.example.BookStore.infra;

import org.apache.ibatis.annotations.Mapper;

import com.example.BookStore.domain.repository.OrderRepository;

@Mapper
public interface OrderMapper extends OrderRepository {}
