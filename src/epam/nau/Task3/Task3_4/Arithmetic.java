package epam.nau.Task3.Task3_4;

public class Arithmetic {

    public static int SumGeometricelements(int a1, double t, int alim) {
        if (a1 < alim) {
            return 0;
        } else {
            return a1 + SumGeometricelements((int) Math.round(a1 * t), t, alim);
        }
    }
}
