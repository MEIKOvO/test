package test;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestTriangle {
    private Triangle tri;
    @Test
    public void test(){
        tri = new Triangle();
        assertEquals(0, tri.triangle(1, 2, 3));
        assertEquals(1, tri.triangle(2, 2, 2));
        assertEquals(2, tri.triangle(2, 2, 3));
        assertEquals(3, tri.triangle(2, 3, 4));
    }
}