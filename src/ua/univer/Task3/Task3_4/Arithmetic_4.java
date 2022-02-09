package ua.univer.Task3.Task3_4;

public class Arithmetic_4 {

    public static int SumGeometricElements(int a1, double t, int alim) {
        if (a1 < alim) {
            return 0;
        } else {
            return a1 + SumGeometricElements((int) Math.round(a1 * t), t, alim);
        }
    }
}
