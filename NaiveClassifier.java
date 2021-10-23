package mathcomp.oletsky.bayes.naivebayes;

public class NaiveClassifier {
    double[] probs;
    double[][] condProbs;
    int kolClasses;
    int kolFeatures;

    public NaiveClassifier(
            double[] probs,
            double[][] condProbs) {
        this.probs=probs;
        this.condProbs = condProbs;
        kolClasses=condProbs.length;
        kolFeatures=condProbs[0].length;
    }

    double getCondProbInBinaryCase(
            int givenClass,
            int featureNo,
            int featureValue
            ) {
        double probOne=condProbs[givenClass][featureNo];
        if (featureValue==1) return probOne;
        else return 1.-probOne;
    }

    double getRawClassPlausibility(
            //Product of conditional probabilities
            int[] sample,
            int givenClass){
        double prod=1.;
        for (int i = 0; i < kolFeatures; i++) {
            prod*=getCondProbInBinaryCase(givenClass,
                    i,
                    sample[i]);
        }
        return prod;

    }

    double fullClassPlausibility(
            int[] sample,
            int givenClass){
        return probs[givenClass]*this.getRawClassPlausibility(
                sample, givenClass
        );
    }

    int classifySample(int[] sample) {
        double max=Double.NEGATIVE_INFINITY;
        int ans=-1;
        for (int cl = 0; cl < kolClasses; cl++) {
            double pl=fullClassPlausibility(sample,cl);
            if (pl>max) {
                ans=cl;
                max = pl;
            }

        }
        return ans;
    }
}
