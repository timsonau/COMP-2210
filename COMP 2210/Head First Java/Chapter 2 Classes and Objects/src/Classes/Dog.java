package Classes;

public class Dog {

    private int size;
    private final String breed;
    private String name;

    public Dog(final int size, final String breed, final String name) {
        this.size = size;
        this.breed = breed;
        this.name = name;
    }

    public void bark() {
        System.out.println("Ruff! Ruff!");
    }

    public int getSize() {
        return  size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return  name;
    }

    public void  setName(String name) {
        this.name = name;
    }
}
