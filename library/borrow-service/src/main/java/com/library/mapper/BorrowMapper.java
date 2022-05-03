package com.library.mapper;

import com.library.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: shg
 * @create: 2022-04-30 8:59 下午
 */
@Mapper
public interface BorrowMapper {

    @Select("select * from DB_BORROW where uid = #{uid}")
    List<Borrow> selectBorrowsByUid(int uid);

    @Select("select * from DB_BORROW where bid = #{bid}")
    List<Borrow> selectBorrowsByBid(int bid);

    @Select("select * from DB_BORROW where bid = #{bid} and uid = #{uid}")
    Borrow selectBorrowByUidAndBid(int uid, int bid);
}
