package com.aor.numbers;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivisibleFilterTest {
    @Test
    public void divisible(){
        DivisibleByFilter filter = new DivisibleByFilter(2);
        assertTrue(filter.accept(-10));
        assertFalse(filter.accept(-5));
        assertFalse(filter.accept(0));
        assertTrue(filter.accept(2));
        assertFalse(filter.accept(15));
    }
}
