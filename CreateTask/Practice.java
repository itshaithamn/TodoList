public class Practice {
    public static void main(String[] args) {
        // Create an instance of the outer class Practice
        Practice practice = new Practice();

        // Create instances of the inner classes Circle and Rectangle
        GraphicObject circle = practice.new Circle();
        GraphicObject rectangle = practice.new Rectangle();

        // Call methods on the Circle and Rectangle objects
        circle.moveTo(10, 20); // Call the moveTo method from the abstract class
        circle.draw(); // Call the draw method from the Circle class
        circle.resize(); // Call the resize method from the Circle class

        rectangle.moveTo(30, 40); // Call the moveTo method from the abstract class
        rectangle.draw(); // Call the draw method from the Rectangle class
        rectangle.resize(); // Call the resize method from the Rectangle class
    }
    
    abstract class GraphicObject{
        int x, y;

        void moveTo(int newX, int newY){
            System.out.println(newY);
            System.out.println(newX);
        }
    
        abstract void draw();
        abstract void resize();
    }

    class Circle extends GraphicObject{
        void draw(){
            System.out.println("1");
            System.out.println("2");
        }
        void resize(){
            System.out.println("One");
            System.out.println("Two");
        }
    }

    class Rectangle extends GraphicObject{
        void draw(){
            System.out.println("3");
            System.out.println("4");
        }
        void resize(){
            System.out.println("Three");
            System.out.println("Four");
        }
    }
}
