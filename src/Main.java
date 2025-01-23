import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(getInfoIarr(15));
        System.out.println(isPolindrom(121));
    }
    public static String getInfoIarr(int l){
        Random random = new Random();
        float sumOfIarr = 0;
        int[] iarr = new int[l];
        for(int i = 0; i<iarr.length; i++){
            iarr[i] = random.nextInt(101);
            sumOfIarr+=iarr[i];
        }
        int varForMax = iarr[0];
        int varForMin = iarr[0];
        for (int j : iarr) {
            if (varForMax < j) {
                varForMax = j;
            }
            if (varForMin > j) {
                varForMin = j;
            }
        }
        return "Array " + Arrays.toString(iarr) + ", Sum " + sumOfIarr + ", Avg " + sumOfIarr/ iarr.length + ", Max " + varForMax + ", Min " + varForMin;
    }
    public static Boolean isPolindrom(Object var){
        String str = var.toString();
        String reversStr = "";
        for(int i = str.length()-1; i>=0; i--){
            reversStr += str.charAt(i);
        }
        return str.equals(reversStr);
    }
}
