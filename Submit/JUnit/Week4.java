public class Week4 {
    /** max2Int.*/
    public static int max2Int(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    /** minArray.*/
    public static int minArray (int[] array) {
        int min_ = array[0];
        int size;
        size = array.length;

        for (int i = 1; i < size; i++) {
            if (array[i] <= min_) {
                min_ = array[i];
            }
        }

        return min_;
    }

    /** calculateBMI. */
    public static String calculateBMI(double weight, double height) {
        double result = weight / (height * height);
        double BMI = (double) Math.round(result * 100) / 100;

        if (BMI < 18.5) {
            return "Thiếu cân";
        }
        if (BMI >= 18.5 && BMI < 23) {
            return "Bình thường";
        }
        if (BMI >= 23 && BMI < 25) {
            return "Thừa cân";
        }
        if (BMI >= 25) {
            return "Béo phì";
        }

        return null;
    }
}
