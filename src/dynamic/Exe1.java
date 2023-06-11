package dynamic;

/**
 * Exe1 is for exercise1.
 * <p>
 * The question is as follows:<br>
 * 现有一段长度为 10 的钢条，可以零成本将其切割为多段长度更小钢条。<br>
 * <table>
 *     <tr>
 *         <td>钢条长度</td>
 *         <td>0</td><td>1</td><td>2</td><td>3</td><td>4</td>
 *         <td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td>
 *     </tr>
 *     <tr>
 *         <td>价格</td>
 *         <td>0</td><td>1</td><td>5</td><td>8</td><td>9</td><td>10</td>
 *         <td>17</td><td>17</td><td>20</td><td>24</td><td>24</td>
 *     </tr>
 * </table>
 * 给出一个切割方案使切割后总收益最高。
 */
public class Exe1 {

    /**
     * Cut a given stick into many parts, each part can sell for a given price determined by its length.
     * Calculate the maximum selling price of a given stick.
     *
     * @param length length of the given stick
     * @param prices an array storing the price of a stick with the specified length
     * @return the maximum selling price of a given stick
     */
    public static int MaxValueOfStick(int length, int[] prices) {
        if (length >= prices.length) throw new AssertionError();
        int[] cutPos = new int[length + 1];
        for (int i = 0; i < cutPos.length; i++)
            cutPos[i] = i;

        int[] maxs = prices.clone();
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int tmp = maxs[j] + maxs[i - j];
                if (tmp > maxs[i]) {
                    maxs[i] = tmp;
                    cutPos[i] = j;
                }
            }
        }

        /*print out cutting plan*/
        int lth = length, remain = lth;
        String plan = "Cutting plan is: ";
        while (remain != cutPos[remain]) {
            plan = plan.concat(cutPos[remain] + "|");
            remain = lth - cutPos[remain];
            lth -= cutPos[remain];
        }
        plan = plan.concat(String.valueOf(remain));
        System.out.println(plan);
        return maxs[length];
    }

}
