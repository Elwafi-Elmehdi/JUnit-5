import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyFirstJUnitTest {
    @Test
    public void test() {
        MathUtils mathUtils = new MathUtils();
        int expect = 12;
        int result = mathUtils.add(4,8);
        assertEquals(expect,result,"Should Add two numbers");
    }

    @Test
    public void testDiscArea() {
        MathUtils mathUtils = new MathUtils();
        Double expect = 50.26548245743669;
        Double result = mathUtils.calculateAreaDisc(4.0);
        assertEquals(expect,result,"Should calculate area of disk");
    }
}
