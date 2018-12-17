package com.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author tb
 * @date 2018/12/13 11:00
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {1,6,3,9,5,100};
        bubble(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    /**
     * min -> max
     * @param arr
     */
    private static void bubble(int[] arr) {
        int tmp;
        int size = arr.length;
        for(int i=0;i<size-1;i++){
            for(int j=0; j<size-i-1;j++){
                if(arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    private static void quick(int[] arr) {

    }
}
