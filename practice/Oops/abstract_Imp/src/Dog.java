//Dog class extends Animal
class Dog extends Animal {

    //Implementing the Abstract method
    @Override
    void sound() {
      System.out.println("Bow Bow !!!");
    }

    //Dog-Specific method
    public void Catch(){
        System.out.println("The dog is running to catch the ball.");
    }

}
