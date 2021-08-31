package com.edu.nbu.cn.thread;

/**
 *
 * @version 1.0
 * @Date 2021/5/13 3:47 下午
 * @since 1.0
 */
public class Producer implements Runnable{

    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            synchronized (product){
                if(product.getCount() >= 100){
//                    System.out.println(Thread.currentThread().getName() + "等待消费者" + product.getCount() + "消费" + product);
                    try {
                        product.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        product.notifyAll();
                    }
                }
                long count = product.getCount();
                count ++;
                product.setCount(count);
                System.out.println(Thread.currentThread().getName() + ";count=" + count +  ";lock : " + product);
            }
        }
    }
}
