package animals;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;
    private String color;

    public Animal(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge() {
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight() {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
       String getYearName = "";
       if(age % 10 == 1) {
           getYearName = "год";
       } else if (age % 10 == 0 || age % 10 >= 5) {
           getYearName = "лет";
       } else if(age % 10 >= 2 && age % 10 <= 4) {
           getYearName = "года";
       } if ((age % 100 >= 11) && (age % 100 <= 14)) {
            getYearName = "лет";
        }
        return "Привет! Меня зовут " + name +
                ", мне " + age + " "+ getYearName +
                ", я вешу - " + weight + " кг "+
                ", мой цвет - " + color + ".";
    }
    public void Say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }
}




