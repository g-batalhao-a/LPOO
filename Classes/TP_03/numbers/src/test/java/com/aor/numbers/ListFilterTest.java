package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ListFilterTest {
    private List<Integer> list;

    @Before
    public void helper(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(-2);
        list.add(-5);

    }

    @Test
    public void positiveFilterStub(){
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        class innerClass implements IListFilter{
            public boolean accept(Integer number) {
                return number > 0;
            }
        }
        innerClass stub = new innerClass();
        ListFilterer listFilter = new ListFilterer(list);
        assertEquals(expected,listFilter.filter(stub));
    }

    @Test
    public void positiveFilterMockito(){
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListFilterer listFilter = new ListFilterer(list);

        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(true);
        Mockito.when(filter.accept(4)).thenReturn(true);
        Mockito.when(filter.accept(-2)).thenReturn(false);
        Mockito.when(filter.accept(-5)).thenReturn(false);
        assertEquals(expected,listFilter.filter(filter));
    }

    @Test
    public void divisibleFilterStub(){
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(-2);

        class innerClass implements IListFilter{
            public boolean accept(Integer number) {
                return number % 2 == 0;
            }
        }
        innerClass stub = new innerClass();
        ListFilterer listFilter = new ListFilterer(list);
        assertEquals(expected,listFilter.filter(stub));
    }

    @Test
    public void divisibleFilterMockito(){
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(-2);

        ListFilterer listFilter = new ListFilterer(list);

        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(false);
        Mockito.when(filter.accept(2)).thenReturn(true);
        Mockito.when(filter.accept(4)).thenReturn(true);
        Mockito.when(filter.accept(-2)).thenReturn(true);
        Mockito.when(filter.accept(-5)).thenReturn(false);
        assertEquals(expected,listFilter.filter(filter));
    }
}
