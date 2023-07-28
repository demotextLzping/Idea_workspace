package RuntimeDataArea;

/**
 * @author: LZPing
 * @date: 2023-03-30 15:59
 * @Description
 */

public class TestInvokeDynamic {

    public static void main(String[] args) {
        I i = C::n;
        I i2 = C::n;
        I i3 = C::n;
        I i4 = () -> {
            C.n();
        };
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }

    @FunctionalInterface
    public interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }
}
