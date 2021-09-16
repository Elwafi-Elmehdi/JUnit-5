import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class MyFirstJUnitTest {

    MathUtils mathUtils;

    @Disabled
    @BeforeAll
    static void beforeAllInit() { // we need to run ths method before the obj is init so we need to make it static
        System.out.println("This needs to run before all");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Passed");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @Test
    public void test() {
        int expect = 12;
        int result = mathUtils.add(4,8);
        assertEquals(expect,result,"Should Add two numbers");
    }

    @Test
    public void testDiscArea() {
        Double expect = 50.26548245743669;
        Double result = mathUtils.calculateAreaDisc(4.0);
        assertEquals(expect,result,"Should calculate area of disk");
    }

    @Test
    public void testDivide() {
        assertThrows(ArithmeticException.class,() -> mathUtils.divide(1,0),"Should throw arithmetic exception");
    }
}
