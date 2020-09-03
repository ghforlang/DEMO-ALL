package com.edu.nbu.cn.beancopy.orika.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Triplet<S,U,V> {
    private S first;
    private U second;
    private V third;
}
