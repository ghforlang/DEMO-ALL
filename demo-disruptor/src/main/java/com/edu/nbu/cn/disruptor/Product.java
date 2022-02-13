package com.edu.nbu.cn.disruptor;

import javafx.event.Event;
import javafx.event.EventType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author laoshi . hua
 * @version 1.0 2021/12/17-3:10 下午
 * @since 1.0
 */
@Getter
@Setter
public class Product extends Event {
    private String id;
    private String name;
    private int weight;

    public Product(EventType<? extends Event> eventType) {
        super(eventType);
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
