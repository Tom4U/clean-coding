package cleancode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LspTest {
    class Rechteck {

        protected double width;
        protected double height;

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double area() {
            return width * height;
        }
    }
    
    class Quadrat extends Rechteck {

        public void setHeight(double value) {
            width = value;
            height = value;
        }

        public void setWidth(double value) {
            width = value;
            height = value;
        }
    }

    class Client {

        Boolean areaVerifier(Rechteck r) {
            r.setWidth(5);
            r.setHeight(4);

            if (r.area() != 20) {
                return false;
            }

            return true;
        }
    }
    
    @Test
    public void testRectangleArea() {
        Rechteck r = new Rechteck();
        Client c = new Client();

        assertTrue(c.areaVerifier(r));
    }

    @Test
    public void testSquareArea() {
        Quadrat s = new Quadrat();
        Client c = new Client();

        assertTrue(c.areaVerifier(s));
    }
}
