package Lesson_5;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static final int size = 100000000;
    static final int parts = 9;

    static public void main (String[] args) {
        float[] arr = new float[size];
        seqMeth(arr);
        concurMeth(arr, parts);
    }

    static public void seqMeth(float[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Sequential implementation: " + (System.currentTimeMillis() - a));
//        System.out.println(Arrays.toString(arr));
    }

    static public void concurMeth(float[] arr, int parts) {
        int pLen = Math.floorDiv(arr.length, parts);
        Thread[] threads = new Thread[parts];
        ArrayList<float[]> arrays = new ArrayList<>(parts);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < parts; i++) {
            arrays.add(Arrays.copyOfRange(arr, i*pLen, i == parts - 1 ? arr.length : (i+1)*pLen));
            final int param = i * pLen;
            final int idx = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    float[] _arr = arrays.get(idx);

                    long a = System.currentTimeMillis();


                    for (int i = 0; i < _arr.length; i++) {
                        _arr[i] = (float)(_arr[i] * Math.sin(0.2f + (i + param) / 5) *
                                Math.cos(0.2f + (i +  param)/ 5) * Math.cos(0.4f + (i + param) / 2));
                    }

                    System.out.println(Thread.currentThread().getName() + " finished : " + (System.currentTimeMillis() - a));
                }
            });
            threads[i].start();
        }

        for (Thread it : threads) {
            try {
                it.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int i = 0;
        for (float[] it : arrays) {
//            System.out.println(Arrays.toString(it));
            System.arraycopy(it, 0, arr, i*pLen, it.length);
            i++;
        }

        System.out.println("Concurrent implementation: " + (System.currentTimeMillis() - a));
//        System.out.println(Arrays.toString(arr));

    }

}
