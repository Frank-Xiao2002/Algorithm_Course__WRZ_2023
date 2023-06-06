package greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Exe2 is for exercise2.
 * <p>
 * The question is as follows:<br>
 * 阿里巴巴走进了装满宝藏的藏宝洞。<br>
 * 藏宝洞里面有 N（N≤100）堆金币，第i堆金币的总重量和总价值分别为mi和vi（1≤mi，vi≤100）。<br>
 * 阿里巴巴有一个承重力为T（T≤1000）的背包，但并没办法将全部的金币都装进去。他想装走尽可能多价值的金币。<br>
 * 所有金币都可以随意分割，分割完的金币重量比（单位价格）不变，请问阿里巴巴最多可以拿走多少价值金币？<br>
 */
public class Exe2 {
    /**
     * Solve the problem Exercise 2 in greedy part.
     *
     * @param m an array to tell the mass of each heap
     * @param v an array to tell the value of each heap
     * @return the maximum value of the bag
     */
    public static double Alibaba(int N, int T, int[] m, int[] v) {
        if (N <= 0 || m.length != N || v.length != N || T <= 0) throw new AssertionError();
        ArrayList<Double> vpm = new ArrayList<>();
        ArrayList<Integer> mass = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            vpm.add((double) v[i] / m[i]);
            mass.add(m[i]);
        }
        System.out.println(vpm);
        Comparator<Double> comparator = new Comparator<>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1 < o2)
                    return -1;
                else if (o1 == o2)
                    return 0;
                else return 1;
            }
        };
        double remain = T, totalValue = 0.0;
        while (remain > 0 && vpm.size() > 0) {
            Double maxVPM = vpm.stream().max(comparator).get();
            int index = vpm.indexOf(maxVPM);
            double used = Math.min(remain, mass.get(index));
            remain -= used;
            totalValue += used * maxVPM;
            vpm.remove(maxVPM);
            mass.remove(index);
        }
        return totalValue;
    }
}
