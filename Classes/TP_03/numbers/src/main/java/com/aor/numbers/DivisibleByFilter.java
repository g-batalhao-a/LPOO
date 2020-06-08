package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private Integer div;
    public DivisibleByFilter(Integer div){
        this.div=div;
    }
    @Override
    public boolean accept(Integer number) {
        if(number==0){return false;}
        if(number%div==0){return true;}
        return false;
    }
}
