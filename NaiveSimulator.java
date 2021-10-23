package mathcomp.oletsky.bayes.naivebayes;

import mathcomp.oletsky.randomchooser.RandomChooser;

import java.util.Random;

public class NaiveSimulator {
    Random rand = new Random();

    static public int[] generateSample(int givenClass,
                                double[][] condProbs) {
        int kolFeatures = condProbs[0].length;
        int[] sample = new int[kolFeatures];
        for (int i = 0; i < kolFeatures; i++) {
            sample[i] = RandomChooser.bernoulliProbe(
                    condProbs[givenClass][i]
            );
        }
        return sample;
    }

}
