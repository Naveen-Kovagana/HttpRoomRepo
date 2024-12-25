//Cat class extends Animal
class Cat extends Animal{

    //Implementing the abstract method
    @Override
    void sound(){
        System.out.println("Meow Meow !!!");
    }

    //Cat-Specific method
    public void scratch(){
        System.out.println("The cat is scratching the furniture.");
    }

}
