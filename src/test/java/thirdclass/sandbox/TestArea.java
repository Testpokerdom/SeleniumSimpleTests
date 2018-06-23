package thirdclass.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestArea {
    @Test
    public void testSquereArea(){

        Squere squere = new Squere(25);
        Assert.assertEquals(squere.squereAreaWithoutArguments(), 625.0 );
    }

    @Test
    public void testRectangleArea(){

        Rectangle rect = new Rectangle(2,16);
        Assert.assertEquals(rect.rectangleAreaWithoutArguments(), 32.0);
    }
}
