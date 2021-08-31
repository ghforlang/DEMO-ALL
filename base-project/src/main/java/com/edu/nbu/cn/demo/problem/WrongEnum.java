package com.edu.nbu.cn.demo.problem;

/**
 *
 * @version 1.0
 * @Date 2021/3/18 5:27 下午
 * @since 1.0
 */
public enum WrongEnum {
    ZERO(100 / 0,"wrong result"),
    ONE(10,new SimpleInterface(){

        @Override
        public Object build(){
            throw new IllegalStateException("ClassA.static{}: Internal Error!");
        }
    });

    public long getValue() {
        return value;
    }

    public Object getDesc() {
        return desc;
    }

    private long value;
    private Object desc;

    WrongEnum(long value, Object desc) {
        this.value = value;
        this.desc = desc;
    }
}
