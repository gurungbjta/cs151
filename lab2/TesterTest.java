import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TesterTest {
    @BeforeAll
    static void setUpBeforeClass() throws Exception{
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception{
    }

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void test(){
        int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
        Arrays.swapLargestAndSmallest(a);
        assertEquals("[5, 4, 9, 1, 2, 6]", java.util.Arrays.toString(a));

        a = new int[] {1, 4, 1, 9, 2, 6};
        Arrays.swapLargestAndSmallest(a);
        assertEquals("[9, 4, 1, 1, 2, 6]", java.util.Arrays.toString(a));

        a = new int[] {1, 4, 2, 9, 9, 6};
        Arrays.swapLargestAndSmallest(a);
        assertEquals("[9, 4, 2, 1, 9, 6]", java.util.Arrays.toString(a));

        a = new int[] {1};
        Arrays.swapLargestAndSmallest(a);
        assertEquals("[1]", java.util.Arrays.toString(a));

    }


}
