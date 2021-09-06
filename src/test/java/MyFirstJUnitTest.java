import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstJUnitTest {
    @Test
    public void test() {
        MathUtils mathUtils = new MathUtils();
        int expect = 7;
        int result = mathUtils.add(4,8);
        Assertions.assertEquals(expect,result,"Should Add two numbers");
    }
}
