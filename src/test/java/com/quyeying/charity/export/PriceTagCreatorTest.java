package com.quyeying.charity.export;

import org.junit.Test;

import static org.junit.Assert.*;

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