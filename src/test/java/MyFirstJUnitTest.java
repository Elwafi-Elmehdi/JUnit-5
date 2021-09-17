import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class MyFirstJUnitTest {

    MathUtils mathUtils;

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
    @DisplayName("Should add two numbers")
    public void test() {
        int expect = 12;
        int result = mathUtils.add(4,8);
        assertEquals(expect,result,"Should Add two numbers");
    }
    @Test
    @DisplayName("Should calculate area of disk")
    public void testDiscArea() {
        Double expect = 50.26548245743669;
        Double result = mathUtils.calculateAreaDisc(4.0);
        assertEquals(expect,result);
    }

    @Test
    @DisplayName("Should throw arithmetic exception")
    public void testDivide() {
        assertThrows(ArithmeticException.class,() -> mathUtils.divide(1,0),"Should throw arithmetic exception");
    }

    @Test
    @Disabled
    @DisplayName("TDD Should not run")
    void failTest() {
        fail("Failed");
    }
}
