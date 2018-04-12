package ntci.scu.trans;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/12
 * Time: 10:08
 */
public class TransThread implements Runnable {

    private AntTransfrom antTransfrom;

    public TransThread(AntTransfrom antTransfrom) {
        this.antTransfrom = antTransfrom;
    }

    @Override
    public void run() {
        try {
            antTransfrom.transfrom(antTransfrom.getFrom(),antTransfrom.getTo(),antTransfrom.getAmount(),antTransfrom.getOrderNo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
