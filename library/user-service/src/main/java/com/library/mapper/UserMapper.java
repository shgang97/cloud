package com.library.mapper;

import com.library.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: shg
 * @create: 2022-04-30 8:24 下午
 */
@Mapper
public interface UserMapper {
    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(int uid);

    @Select("select rest from DB_USER where uid = #{uid}")
    int selectRestById(int uid);

    @Update("update DB_USER set rest = #{rest} where uid = #{id}")
    int updateRestById(int id, int rest);
}
