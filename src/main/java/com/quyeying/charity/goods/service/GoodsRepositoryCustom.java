package com.quyeying.charity.goods.service;

import com.quyeying.charity.domain.Goods;
import com.quyeying.charity.goods.dto.SaleMoneyDto;
import com.quyeying.charity.report.dto.GroupReportDto;
import org.springframework.data.domain.Page;

/**
 * User: bysun
 * Date: 2014/7/29
 * Time: 17:18
 */
public interface GoodsRepositoryCustom {

    /**
     * 根据dto参数查询
     *
     * @param dto      查询参数
     * @param pageable 分页信息
     * @return 捐品列表
     */
    Page<Goods> findByDto(GroupReportDto dto);

    /**
     * 根据goods type 查询销售额
     * @return 销售额
     */
    SaleMoneyDto findSaleMoney(String... goodsType);
}
