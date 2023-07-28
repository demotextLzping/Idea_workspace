package RuntimeDataArea;

/**
 * @author: LZPing
 * @date: 2023-03-29 22:07
 * @Description
 */

public class TestInvokeSpecial  {
    public static void main(String[] args) {
        TestInvokeSpecial t = new TestInvokeSpecial();
        t.m();
        t.n();
    }

    public  final  void m(){}
    private  void n(){}
}
