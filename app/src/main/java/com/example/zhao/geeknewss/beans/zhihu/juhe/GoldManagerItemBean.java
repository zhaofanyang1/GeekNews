package com.example.zhao.geeknewss.beans.zhihu.juhe;

public class GoldManagerItemBean {
    private int index;

    private boolean isSelect;

    public GoldManagerItemBean() {
    }

    public GoldManagerItemBean(int index, boolean isSelect) {
        this.index = index;
        this.isSelect = isSelect;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getIsSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }


    @Override
    public String toString() {
        return "GoldManagerItemBean{" +
                "index=" + index +
                ", isSelect=" + isSelect +
                '}';
    }
}
