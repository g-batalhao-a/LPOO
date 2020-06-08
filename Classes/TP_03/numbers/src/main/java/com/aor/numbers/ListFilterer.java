package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private List<Integer> list;
    public ListFilterer(List<Integer> list){
        this.list=list;
    }
    public List<Integer> filter(IListFilter filter){
        List<Integer> filteredlist=new ArrayList<>();
        for(Integer number: list){
            if(filter.accept(number)){
                filteredlist.add(number);
            }
        }
        return filteredlist;
    }
}
