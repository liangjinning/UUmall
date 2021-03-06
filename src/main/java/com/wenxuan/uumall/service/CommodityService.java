package com.wenxuan.uumall.service;


import com.wenxuan.uumall.dto.DtoFactory;
import com.wenxuan.uumall.entity.*;
import com.wenxuan.uumall.mapper.CommodityMapper;
import com.wenxuan.uumall.request.CommodityDto;
import com.wenxuan.uumall.request.CommoditySimpleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommodityService {

    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    CommodityAssessService commodityAssessService;
    @Autowired
    CommodityDetailsService commodityDetailsService;
    @Autowired
    CommodityManagerService commodityManagerService;
    @Autowired
    BusinessService businessService;

    public List<CommoditySimpleDto> search(String manager, Integer page, Integer per){
        List<Commodity> commodities = commodityMapper.search(manager, page, per);
        List<CommoditySimpleDto> dtos = commodities.stream().map(commodity -> {
            CommoditySimpleDto dto =  DtoFactory.commoditySimpleDto(commodity);
            Business business = businessService.findOne(dto.getBusinessId()).getData();
            if (business != null) {
                dto.setBusinessName(business.getNickName());
            }
            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }

    public CommodityDto findOne(Long id){
        Commodity commodity = commodityMapper.findOne(id);
        CommodityDto dto = DtoFactory.commodityDto(commodity);
        List<CommodityAssess> commodityAssesses = commodityAssessService.findByCommodity(dto.getId());
        if (commodityAssesses != null && commodityAssesses.size() != 0) {
            dto.setCommodityAssessList(commodityAssesses);
        }
        List<CommodityDetails> commodityDetails = commodityDetailsService.findByCommodity(dto.getId());
        if (commodityDetails != null && commodityDetails.size() != 0) {
            dto.setCommodityDetailsList(commodityDetails);
        }
        List<CommodityManager> commodityManagers = commodityManagerService.findByCommodity(dto.getId());
        if (commodityManagers != null && commodityManagers.size() != 0){
            dto.setCommodityManagerList(commodityManagers);
        }
        Business business = businessService.findOne(dto.getBusinessId()).getData();
        if (business != null) {
            dto.setBusiness(business);
        }
        return dto;
    }

}
