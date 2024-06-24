package interview.study.enums;

import lombok.Getter;

public enum  CountryEnum
{
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"韩"),SXI(6,"魏"),SEVEN(7,"周");

    @Getter
    private Integer retcode;
    @Getter
    private String retMessage;

    CountryEnum(Integer retcode, String retMessage)
    {
        this.retcode = retcode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index)
    {
//        CountryEnum[] myArr = CountryEnum.values();
//        for (CountryEnum element: myArr) {
//            if(index == element.getRetcode()){
//                return element;
//            }
//        }
        return null;
    }
}
