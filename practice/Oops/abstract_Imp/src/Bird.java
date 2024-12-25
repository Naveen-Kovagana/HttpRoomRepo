//Bird class extends Animal
class Bird extends Animal{

    //Implementing abstract method
    @Override
    void sound(){
        System.out.println("Chirp Chirp !!!");
    }

    //Bird-Specific method
    public void fly(){
        System.out.println("The bird is flying in Dark Night.");
    }
}
