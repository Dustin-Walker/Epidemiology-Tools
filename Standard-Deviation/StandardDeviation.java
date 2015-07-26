import java.util.ArrayList;

public class StandardDeviation {
     /**
     * Standard deviation can be calculated as the square root of the variance as demonstrated here
     * @param inputList List of integers to calculate standard deviation
     * @return Standard deviation of list
     */
    public double standardDeviation(ArrayList<Integer> inputList){
        return Math.sqrt(variance(inputList));
    }

    /**
     * Method returns the variance when given an arrayList of integers.
     * @param inputList List of integers to calculate variance
     * @return Variance of list
     */
    public double variance(ArrayList<Integer> inputList){
        int n=0, sum1=0, sum2=0;
        for(int i: inputList){
            n+=1;
            sum1+=i;
        }
        double mean = (double) sum1/n;
        for(int i: inputList)
            sum2 += (i - mean) * (i - mean);
        return (double) sum2/(n);
    }
}
