package ua.advanced.practice3.task1;

public class Main {
    public static void main(String[] args) {
        RangedOpsIntegerSet firstSet = new RangedOpsIntegerSet();

        firstSet.add(1, 5);

        for(Integer el : firstSet){
            System.out.println(el);
        }
        System.out.println("================");

        RangedOpsIntegerSet secondSet = new RangedOpsIntegerSet();

        secondSet.add(1, 5);
        secondSet.add(9, 11);

        for(Integer el : secondSet){
            System.out.println(el);
        }
        System.out.println("================");

        RangedOpsIntegerSet thirdSet = new RangedOpsIntegerSet();

        thirdSet.add(1, 15);
        thirdSet.remove(3, 12);

        for(Integer el : thirdSet){
            System.out.println(el);
        }
    }
}
