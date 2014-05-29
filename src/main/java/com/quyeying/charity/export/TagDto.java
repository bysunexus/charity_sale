package com.quyeying.charity.export;

/**
 * User: bysun
 * Date: 2014/5/29 0029
 * Time: 12:00
 */
public class TagDto {
    private String GoodsType;
    private Integer total;
    private boolean horizontal = true;
    private boolean vertical = true;
    private boolean back;

    public String getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(String goodsType) {
        GoodsType = goodsType;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public boolean isBack() {
        return back;
    }

    public void setBack(boolean back) {
        this.back = back;
    }
}
