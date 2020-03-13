package com.aor.numbers;
import org.junit.Test;
import static org.junit.Assert.*;

public class PositiveFilterTest {
    @Test
    public void positive(){
        PositiveFilter filter = new PositiveFilter();
        assertFalse(filter.accept(-10));
        assertFalse(filter.accept(-5));
        assertFalse(filter.accept(0));
        assertTrue(filter.accept(2));
        assertTrue(filter.accept(15));
    }
}
