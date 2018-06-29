package com.example.sample01.mapper;

import com.example.sample01.service.LoginVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginMapper {
    LoginVO getUserData(Map<String, String> map);
}
