package ntci.scu.trans;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/12
 * Time: 9:14
 */
public interface Transfrom {

    /**
     * 转账函数
     *
     * @param from    转出账号
     * @param to      转入账号
     * @param amount  转账金额
     * @param orderNo 订单号
     * @return boolean 是否处理成功
     */
    public boolean transfrom(String from, String to, double amount, String orderNo) throws Exception;
}
