public class Cat {
    private String name;
    private String breed;
    private int age;

    public Cat() {
        this.name = "Sonya";
        this.breed = "Russian blue";
        this.age = 12;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
