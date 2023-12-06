import java.io.*;

class Cat implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;
    transient double weight;

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public static void main(String[] args) {
        // Запись объекта в файл
        Cat cat = new Cat("Whiskers", 3, 5.5);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.ser"))) {
            oos.writeObject(cat);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение объекта из файла
        Cat deserializedCat = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cat.ser"))) {
            deserializedCat = (Cat) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Вывод информации о коте
        if (deserializedCat != null) {
            System.out.println("Name: " + deserializedCat.name);
            System.out.println("Age: " + deserializedCat.age);
            System.out.println("Weight: " + deserializedCat.weight);
        }
    }
}

