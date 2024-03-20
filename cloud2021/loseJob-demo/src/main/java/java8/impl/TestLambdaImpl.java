package java8.impl;


public class TestLambdaImpl{

    public static void main(String[] args) {
        MultiParamNoReturn multiParamNoReturn = ((int a, int b) -> {
            System.out.println("多参无返回！");
        });
        multiParamNoReturn.test(1, 2);

        MultiParamReturn multiParamReturn = ((int a, int b) -> {
            System.out.println("多参有返回！");
            return "bingo";
        });
        multiParamReturn.test(1, 2);

        NoParamNoReturn noParamNoReturn = (() -> {
            System.out.println("无参无返回！");
        });
        noParamNoReturn.test();

        NoParamNoReturn noParamReturn = (() -> {
            System.out.println("无参有返回！");
        });
        noParamReturn.test();

        OneParamNoReturn oneParamNoReturn = ((int a) -> {
            System.out.println("单参无返回！");
        });
        oneParamNoReturn.test(1);

        OneParamReturn oneParamReturn = ((int a) -> {
            System.out.println("单参有返回！");
            return "bingo";
        });
        oneParamReturn.test(1);

    }




}
