package java8.impl;

// 指定某个接口必须是函数式接口
/**
 * 无参无返回
 */
@FunctionalInterface
interface NoParamNoReturn {

     void test();
}

/**
 * 单参无返回
 */
@FunctionalInterface
interface OneParamNoReturn {

    void test(int a);
}

/**
 * 多参无返回
 */
@FunctionalInterface
interface MultiParamNoReturn {

    void test(int a, int b);
}

/**
 * 单参有返回
 */
@FunctionalInterface
interface OneParamReturn {

    String test(int a);
}

/**
 * 多参有返回
 */
@FunctionalInterface
interface MultiParamReturn {

    String test(int a, int b);
}

/**
 * 无参有返回
 */
@FunctionalInterface
interface NoParamReturn {

    String test(int a, int b);
}
