package mathcomp.oletsky.bayes.naivebayes;

import mathcomp.oletsky.mathhelper.VectMatr;

public class NaiveBayesTester {
    public static void main(String[] args) {
        //Setting known information
        final int KOL_CLASSES=2;
        final int KOL_FEATURES=5;

        //Apriori probabilities of classes
        double[] probs = {0.5, 0.5};

        //Conditional probabilities features by classes
        //All features are binary
        //Rows correspond to classes
        //Columns correspond to features
        double[][] condProbs = {
                {0.1, 0.9, 0.2, 0.8, 0.3, 0.8, 0.3},
                {0.7, 0.2, 0.9, 0.3, 0.7, 0.2, 0.6}
        };

        //Getting sample
        int givenClass=1;
        int[] sample=NaiveSimulator.generateSample(
                givenClass,
                condProbs);
        System.out.println("Simulated sample:");
        VectMatr.showIntegerArray(sample);

        //Classifying
        NaiveClassifier naiveClassifier = new NaiveClassifier(
                probs,
                condProbs
        );
        System.out.println("Plausibilities for given sample:");

        for (int cl=0; cl<=1; cl++) {
            System.out.println("Class No. "+cl);
            System.out.println("Raw plausibility: "+
                    naiveClassifier.getRawClassPlausibility(
                            sample,cl
                    ));
            System.out.println("Full plausibility: "+
                    naiveClassifier.fullClassPlausibility(
                            sample,cl
                    ));
            System.out.println("---------");
        }
        System.out.println("Result of classifying: "+
                naiveClassifier.classifySample(sample));

    }
}
