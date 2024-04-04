package newFeathers.study;

import java.util.concurrent.ConcurrentHashMap;

public class TestDemo {
    public static void main(String[] args) {
        // 这沙雕java还单独存到常量池里边了，导致这样输出的直接false；
        String str1 = new StringBuffer("ja").append("va").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());
        System.out.println(str1.equals(str1.intern()));

        String str2 = new StringBuffer("58").append("city").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());


        // 还可以这样写，但是要解决报错，就不搞了
//        Collections.sort(students,Student.Comparator.comparing(Student::getName).thenComparingInt(Student::getAge));

        ConcurrentHashMap<Object, Object> s = new ConcurrentHashMap<>();


    }

    public class Student implements Comparable<Student>{

        private int age;
        private String name;

        @Override
        public int compareTo(Student o) {
            int flag = this.name.compareTo(o.name);
            if(flag != 0){
                flag = this.age - o.age;
            }
            return flag;
        }
    }



}
