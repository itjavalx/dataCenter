package com.ljs.springbootplace.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Mapper
public interface MyMapper {

    @Select("select user_name from news_user where user_id = #{id}")
    String getUserNameById(Integer id);

}
