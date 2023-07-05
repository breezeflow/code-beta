package org.breeze.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.breeze.mybatis.domain.User;

/**
 * @author andy
 * @version 2023/06/30
 */
@Mapper
public interface UserMapper {

    User selectById(@Param("id") int id);

    int updateById(@Param("user") User user);

}
