package ntci.scu.trans;

import ntci.scu.util.Constant;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/12
 * Time: 9:25
 */
public class AntTransfrom implements Transfrom {

    private String from;
    private String to;
    private double amount;
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AntTransfrom() {

    }

    public AntTransfrom(String from, String to, double amount, String orderNo) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.orderNo = orderNo;
    }

    @Override
    public synchronized boolean transfrom(String from, String to, double amount, String orderNo) throws Exception {
        if (Constant.account.get(from) < amount) {
            throw new Exception("账户余额不足");
        }
        if (Constant.order.contains(orderNo)) {
            throw new Exception("该订单已经处理");
        }
        //储存已经处理的订单号
        Constant.order.add(orderNo);
        //对相应的账号余额进行更新
        Constant.account.put(from, Constant.account.get(from) - amount);
        Constant.account.put(to, Constant.account.get(to) + amount);
        System.out.println(Thread.currentThread() + "\t" + from + "余额：" + Constant.account.get(from));
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj.getClass() == AntTransfrom.class) {
            //同一对from和to
            return ((AntTransfrom) obj).getFrom().equals(this.getFrom());
        }
        return false;
    }
}
