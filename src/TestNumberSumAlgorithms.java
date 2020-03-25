import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;

public class TestNumberSumAlgorithms {
    public static void test() {
        int maxNumericNumber = 9;
        int testNum = 1000000;
        double[] midTimeIterAlg = new double[maxNumericNumber];
        double[] midTimeRecurrAlg = new double[maxNumericNumber];

        long timeStart, timeEnd;
        Random rand = new Random();
        for (int i = 0; i < maxNumericNumber; i++) {
            int sumTimeIterAlg = 0;
            int sumTimeRecurrAlg = 0;
            int minNumber = (int) Math.pow(10, i);
            int maxNumber = (int) Math.pow(10, i + 1) - 1;
            for(int j = 0; j < testNum; j++) {
                int num = minNumber + rand.nextInt(maxNumber - minNumber);
                timeStart = System.nanoTime();
                NumberUtils.getNumericSumIteration(num);
                timeEnd = System.nanoTime();
                sumTimeIterAlg += timeEnd - timeStart;
                timeStart = System.nanoTime();
                NumberUtils.getNumericSumRecurrent(num);
                timeEnd = System.nanoTime();
                sumTimeRecurrAlg += timeEnd - timeStart;
            }
            midTimeIterAlg[i] = (double) sumTimeIterAlg / testNum;
            midTimeRecurrAlg[i] = (double) sumTimeRecurrAlg / testNum;
        }
        System.out.println("Среднее время работы итерационного и рекуррентного алгоритмов в зависимости от количества цифр числа:");
        for (int i = 0; i < maxNumericNumber; i++) {
            System.out.println((i + 1) + " : " + midTimeIterAlg[i] + " нс" + "   " + midTimeRecurrAlg[i] + " нс");
        }
    }
}
