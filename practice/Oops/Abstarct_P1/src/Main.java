public class Main {
    public static void main(String[] args) {

        Shape s1 = new Circle("Purple", 4.56);
        Shape s2 = new Rectangle("Red", 3, 6.5);

        System.out.println(s1.toString());
        System.out.println(s2.toString());

    }
}