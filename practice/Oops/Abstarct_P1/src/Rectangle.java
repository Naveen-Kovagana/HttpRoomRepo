class Rectangle extends Shape {

    double length;
    double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        System.out.println("Rectangle Constructor is Called !");
        this.length = length;
        this.width = width;
    }

    @Override double area() {
        return length * width;
    }

    @Override public String toString(){
        return "Rectangle color is : " + super.getColor() + " and the area is : " + area();
    }

}
