package com.quyeying.charity.tag;

import org.junit.Test;

public class PriceTagCreatorTest {

    @Test
    public void testCreate() throws Exception {
        TagDto dto = new TagDto();
        dto.setGoodsType("A");
        dto.setTotal(200);
        PriceTagCreator ptc = new PriceTagCreator(dto);
        ptc.create();
    }
}