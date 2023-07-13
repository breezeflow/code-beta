package org.breeze.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.breeze.mybatis.domain.User;

import java.util.Map;

/**
 * @author andy
 * @version 1.0.0
 */
@Mapper
public interface UserMapper {

    User selectById(@Param("id") int id);

    int updateById(@Param("user") User user);

    int updateByMap(@Param("map") Map<Integer, String> map);

    int updateByMap2(@Param("map") Map<Integer, String> map);

}
