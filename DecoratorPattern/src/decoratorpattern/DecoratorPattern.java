package decoratorpattern;

public class DecoratorPattern {

    public static void main(String[] args) {

        RectangleDecorator rectangleDecorator = new RectangleDecorator(new Rectangle(1, 3));
        
        System.out.println(rectangleDecorator.r.area());
        System.out.println(rectangleDecorator.perimeter());
        
        
    }

}
