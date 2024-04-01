import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Test
    public void testFindLastNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.findLast(null, 3);});
    }


    @Test
    public void testFindLastEmpty() {
        // For any input where y appears in the second or later position, there is no error. Also,
        // if x is empty, there is no error.
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    @Test
    public void testOddOrPosNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null);});
    }


    @Test
    public void testOddOrPosAllPositives() {
        // Any nonempty x with only non-negative elements works, because the first part of the
        // compound if-test is not necessary unless the value is negative.
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    @Test
    public void testOddOrPositiveBothPositivesAndNegatives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    @Test
    void testCountOf_TargetInArray() {
        // Test case where the target is present in the array
        int[] array = {1, 2, 3, 4, 5, 5, 6};
        int target = 5;
        int expectedResult = 2; // The target '5' appears twice in the array
        int actualResult = ArrayUtils.countOf(array, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCountOf_TargetNotInArray() {
        // Test case where the target is not present in the array
        int[] array = {1, 2, 3, 4, 6};
        int target = 5;
        int expectedResult = 0; // The target '5' does not appear in the array
        int actualResult = ArrayUtils.countOf(array, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCountOf_EmptyArray() {
        // Test case where the array is empty
        int[] array = {};
        int target = 5;
        int expectedResult = 0; // The target '5' cannot appear in an empty array
        int actualResult = ArrayUtils.countOf(array, target);
        assertEquals(expectedResult, actualResult);
    }
}