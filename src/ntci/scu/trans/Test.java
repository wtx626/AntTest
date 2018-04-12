package ntci.scu.trans;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/12
 * Time: 9:45
 */
public class Test {
    //使用hashmap来存放账户和余额信息
    volatile static HashMap<String, Double> account = new HashMap<>();

    public static void main(String[] args) throws Exception {
        account.put("001", (double) 400);
        account.put("002", (double) 300);
        account.put("003", (double) 50);
        account.put("004", (double) 20);
        account.put("005", (double) 100);
        AntTransfrom antTransfrom = new AntTransfrom("001", "004", 5, "001");
        //假设三个线程同时执行相同的转账
        for (int i = 0; i < 5; i++) {
            TransThread transThread = new TransThread(antTransfrom);
            Thread thread = new Thread(transThread);
            thread.start();
        }
    }
}
