package com.algorithm.sort;

/**
 *
 * 将一个非负元素数组中的所有元素排列组合在一起，找出值最大的那个排列情况。例如 [0, 9, 523, 94, 10, 4]，排列组合后值最大数为：9945234100
 * 确定使用排序算法实现；
 * 与传统排序不同之处为元素之间的比较规则；
 *
 * 本问题的排序比较规则可以描述为：假设参与比较的两个元素为 A、B（初始时 A 在 B 前，排序结果从左至右为由大到小），比较时如果排列 A_B 小于排列 _B_A_，A 和 B 则交换位置，反之不交换。
 * @author tb
 * @date 2018/12/4 17:37
 */
public class MaxValue {

    public static void main(String[] args) {
        int[] ar = {0, 9, 523, 94, 10, 4};
        MaxValue alg = new MaxValue();
        System.out.println(alg.maxStr(alg.bubble(ar)));
    }

    private String maxStr(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for(int a: ar){
            sb.append(a);
        }
        return sb.toString();
    }

    private int[] bubble(int[] ar) {
        final int len = ar.length;
        if(len < 2) {
            return ar;
        }
        boolean change = true;
        for(int i=1;i<=len && change;i++){
            change = false;
            for(int j=len-1; j>i-1;j--){
                if(compare(ar[j-1],ar[j]) > 0) {
                    int tmp = ar[j-1];
                    ar[j-1] = ar[j];
                    ar[j] = tmp;
                    change = true;
                }
            }
        }
        return ar;
    }

    private int compare(int a, int b) {
        if(a == b){
            return 0;
        }
        return plus(a,b) > plus(b,a) ? -1: 1;
    }

    private int plus(int a, int b) {
        return Integer.parseInt(a+""+b);
    }
}
