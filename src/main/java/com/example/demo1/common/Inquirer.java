package com.example.demo1.common;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inquirer {
    private List<BooleanExpression> expressions;
    public  Inquirer(){
        expressions=new ArrayList<>();
    }
    public Inquirer putExpression(BooleanExpression expression){
        expressions.add(expression);
        return  this;
    }
    public Predicate buildQuery(){
        BooleanExpression be=null;
        for (int i=0;i<expressions.size();i++){
            if(i==0){
                be=expressions.get(0);
            }else{
                be=be.and(expressions.get(i));
            }
        }
        return  be;
    }
    public <T> List<T> iteratorToList(Iterable<T> list){
        List<T> result=new ArrayList<>();
        Iterator<T> data=list.iterator();
        while (data.hasNext()){
            result.add(data.next());
        }
        return  result;
    }
}
