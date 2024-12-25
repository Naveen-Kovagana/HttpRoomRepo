public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        Owner owner = new Owner();

        owner.makeSound(dog);
        owner.makeSound(cat);
        owner.makeSound(bird);

        owner.makeSleep(dog);
        owner.makeSleep(cat);
        owner.makeSleep(bird);

        dog.Catch();
        cat.scratch();
        bird.fly();

    }
}