package com.edu.nbu.easyrules.web;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author laoshi . hua
 * @version 1.0 2022/2/18-6:01 下午
 * @since 1.0
 */
@Rule(name = "filterRule",description="filterRule")
public class FilterRule {
    private static final String NEED_FILTER = "needFilter";

    @Condition
    public boolean needFilter(@Fact("request") HttpServletRequest request){
        return request.getParameter(NEED_FILTER) != null;
    }

    @Action
    public void setNeedFilter(@Fact("request") HttpServletRequest request){
        request.setAttribute(NEED_FILTER,true);
    }
}
