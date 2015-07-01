import java.util.ArrayList;

public class StandardDeviation {

    public static void main(String[] args) {
        ArrayList<Integer> dataSet = new ArrayList<Integer>();
        for(int i = 1; i <= 5; i++) dataSet.add(i);
          System.out.println(dataSet.toString());
        StandardDeviation stddv = new StandardDeviation();
        System.out.println(stddv.standardDeviationUsingVariance(dataSet));
        /*These two lines print out:
            [1, 2, 3, 4, 5]
            1.4142135623730951
        */
    }

    public double standardDeviationUsingVariance(ArrayList<Integer> inputList){
        return Math.pow(twoPassVariance(inputList), 0.5);
    }

    //Algorithm obtained from this page
    //http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
    public double twoPassVariance(ArrayList<Integer> inputList){
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
