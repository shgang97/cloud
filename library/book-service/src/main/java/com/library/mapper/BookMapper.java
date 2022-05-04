package com.library.mapper;

import com.library.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: shg
 * @create: 2022-04-30 8:50 下午
 */
@Mapper
public interface BookMapper {

    @Select("select * from DB_BOOK where bid = #{bid}")
    Book getBookById(int bid);

    @Select("select stock from DB_BOOK  where bid = #{bid}")
    int selectStockById(int bid);

    @Update("update DB_BOOK set stock = #{stock}  where bid = #{bid}")
    int updateStockById(int bid, int stock);
}
