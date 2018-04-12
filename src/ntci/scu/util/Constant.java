package ntci.scu.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @program: AntTest
 * @author: wutianxiong
 * @create: 2018-04-12 21:15
 **/
public class Constant {
    //使用hashmap来存放账户和余额信息
    public volatile static ConcurrentHashMap<String, Double> account = new ConcurrentHashMap<>();
    //存放订单是否已经处理
    public volatile static ConcurrentSkipListSet<String> order = new ConcurrentSkipListSet<>();
}
