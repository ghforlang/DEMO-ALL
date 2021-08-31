package com.edu.nbu.cn.innerclass;

import java.util.Iterator;

/**
 *
 * @version 1.0
 * @Date 2021/6/22 10:22 上午
 * @since 1.0
 */
public class DataStructure {
    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    private void printEven(){
        DataStructureIterator evenIterator = this.new EvenIterator();
        while (evenIterator.hasNext()){
            System.out.println(evenIterator.next() + ",");
        }
    }

    interface DataStructureIterator extends Iterator<Integer> {}

    private class EvenIterator implements DataStructureIterator{
        private int nextIndex = 0;
        @Override
        public boolean hasNext() {
            return nextIndex <= SIZE -1;
        }

        @Override
        public Integer next() {
            Integer result = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;
            return result;
        }
    }

    public static void main(String[] args) {
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}
