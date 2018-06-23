package thirdclass.sandbox;

public class Rectangle {

    public double firstSide;
    public double secondSide;

    public Rectangle(double firstSide, double secondSide){

        this.firstSide = firstSide;
        this.secondSide = secondSide;

    }

    public double rectangleAreaWithoutArguments(){

        return firstSide * secondSide;
    }
}
