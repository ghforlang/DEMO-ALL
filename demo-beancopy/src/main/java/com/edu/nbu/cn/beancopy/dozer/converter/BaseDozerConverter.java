package com.edu.nbu.cn.beancopy.dozer.converter;

import org.dozer.DozerConverter;

public class BaseDozerConverter<A,B> extends DozerConverter<A,B> {

    public BaseDozerConverter(Class<A> prototypeA, Class<B> prototypeB) {
        super(prototypeA, prototypeB);
    }

    public  B convertTo(A var1, B var2){
        return  null;
    }

    public B convertTo(A source) {
        return this.convertTo(source, null);
    }

    public A convertFrom(B var1, A var2){
        return null;
    }

    public A convertFrom(B source) {
        return this.convertFrom(source, null);
    }

}
