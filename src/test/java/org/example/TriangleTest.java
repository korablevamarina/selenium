package org.example;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void testCalcTriangleSq(){
        double S = Lesson4.calcTriangleSq(3, 5,4);
        Assert.assertEquals(6.0, S, 0);
        S = Lesson4.calcTriangleSq(3, 5,2);
        Assert.assertEquals(0, S, 0);
    }
}
