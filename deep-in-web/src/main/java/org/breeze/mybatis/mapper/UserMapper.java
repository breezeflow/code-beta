package org.breeze.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.breeze.mybatis.domain.User;

/**
 * @author andy
 * @version 2023/06/30
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM test.user WHERE id = #{id}")
    User select(int id);

}
