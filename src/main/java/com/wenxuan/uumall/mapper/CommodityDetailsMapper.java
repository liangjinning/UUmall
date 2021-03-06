package com.wenxuan.uumall.mapper;


import com.wenxuan.uumall.entity.CommodityDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommodityDetailsMapper {

    @Select("select * from commodity_details where commodity_id = #{commodity_id}")
    List<CommodityDetails> findByCommodity(@Param("commodity_id") Long commodity_id);
}
