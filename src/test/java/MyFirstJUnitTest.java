import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

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
        Assumptions.assumeTrue(expect == 12);
        int result = mathUtils.add(4,8);
        assertEquals(expect,result,"Should Add two numbers");
    }
    @Test
    @DisplayName("Should calculate area of disk")
    public void testDiscArea() {
        Double expect = 50.26548245743669;
        // Assuming that expected is a double
        assumeTrue(expect instanceof Double);
        Double result = mathUtils.calculateAreaDisc(4.0);
        assertEquals(expect,result);
    }

    @Test
    @DisplayName("Should throw arithmetic exception")
    @EnabledOnOs(OS.LINUX)
    public void testDivide() {
//        boolean isServerUp = false;
//        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class,() -> mathUtils.divide(1,0),"Should throw arithmetic exception");
    }

    @Test
    @Disabled
    @DisplayName("TDD Should not run")
    void failTest() {
        fail("Failed");
    }

    @Test
    @DisplayName("Should only run on JRE version 11")
    @EnabledOnJre(JRE.JAVA_11)
    void testJRE() {
        assertEquals(1,1);
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4,mathUtils.multiply(2,2)),
                () -> assertEquals(0,mathUtils.multiply(4,0)),
                () -> assertEquals(-4,mathUtils.multiply(4,-1))
        );
    }

}
