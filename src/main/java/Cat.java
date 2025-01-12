public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return "Cat name = " + this.get_name() + ", age = " + this.get_age();

    }

}
