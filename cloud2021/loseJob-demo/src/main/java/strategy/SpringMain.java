package strategy;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class SpringMain {

    //SpringBoot引用策略模式
    @Resource
    private Map<String, IStrategySpringTest> mapSpring;

    // 这个注解暂时不可用，不知到那边的Service怎么样，暂时就这样吧，可能是xml文件或者哪配置的原因，
    // 但是不想搞了，本地这些项目本来就一团乱麻QAQ；
    @Resource
    private Map<String, String> map = new HashMap<String,String>();

    IStrategySpringTest test = mapSpring.get("你想用哪种策略类比");

//    test.print("");


}
