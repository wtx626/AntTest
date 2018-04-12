package ntci.scu.trans;

import ntci.scu.util.Constant;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/12
 * Time: 9:45
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Constant.account.put("001", (double) 400);
        Constant.account.put("002", (double) 300);
        Constant.account.put("003", (double) 50);
        Constant.account.put("004", (double) 20);
        Constant.account.put("005", (double) 100);
        AntTransfrom antTransfrom = new AntTransfrom("001", "004", 5, "001");
        //假设三个线程同时执行相同的转账
        for (int i = 0; i < 3; i++) {
            TransThread transThread = new TransThread(antTransfrom);
            Thread thread = new Thread(transThread);
            thread.start();
        }
    }
}
