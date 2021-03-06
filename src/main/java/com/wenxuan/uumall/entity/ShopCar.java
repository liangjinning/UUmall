package com.wenxuan.uumall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * table name:  shop_car
 * author name: wenxuan
 * create time: 2019-04-25 17:35:51
 */

@Getter
@Setter
@ApiModel
public class ShopCar{

	@ApiModelProperty("id")
	@JsonProperty("id")
	private Long id;
	@ApiModelProperty("用户id")
	@JsonProperty("user_id")
	private Long userId;
	@ApiModelProperty("商品id")
	@JsonProperty("commodity_id")
	private Long commodityId;

	@ApiModelProperty("商品数量")
	@JsonProperty("number")
	private Long number;

}

