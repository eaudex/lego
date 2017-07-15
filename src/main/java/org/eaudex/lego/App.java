package org.eaudex.lego;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] inds = {1, 2, 3};
        double[] vals = {1.0, 2.0, 3.0};

        Point pt = new Point(3, inds, vals);
        for (IndexValue indval : pt) {
            System.out.println(indval.index() + " " + indval.value());
        }

        double[] weights = new double[5];
        for (int i=0; i<weights.length; ++i)
            weights[i] = (double) i;

        Model lm = new LinearModel(weights);
        double dv = lm.eval(pt);
        System.out.println(dv);

    }

}
