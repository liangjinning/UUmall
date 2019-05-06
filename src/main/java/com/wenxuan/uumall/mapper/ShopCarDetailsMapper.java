package com.wenxuan.uumall.mapper;


import com.wenxuan.uumall.entity.ShopCarDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopCarDetailsMapper {

    @Select("select * from shop_car_details where s_id = #{s_id}")
    List<ShopCarDetails> find(@Param("s_id")Long s_id);

    @Insert("insert into shop_car_details(s_id,name,manager) value (#{s_id},#{name},#{manager}")
    ShopCarDetails add(@Param("s_id")Long s_id,@Param("name")String name,@Param("manager")String manager);
}