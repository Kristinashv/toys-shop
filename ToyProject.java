import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyProject {

    // Класс-конструктор для игрушек
    static class Toy {
        int id;
        String name;
        int frequency;

        public Toy(int id, String name, int frequency) {
            this.id = id;
            this.name = name;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        // Массивы для хранения информации об игрушках
        int[] ids = {1, 2, 3};
        String[] names = {"Кукла", "Машинка", "Мяч"};
        int[] frequencies = {5, 3, 2}; // Частоты выпадения игрушек

        // Создание приоритетной очереди для хранения игрушек
        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.frequency, t1.frequency));

        // Заполнение очереди игрушками
        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toyQueue.offer(toy);
        }

        // Вызов get 10 раз и запись результатов в файл
        try {
            File file = new File("results.txt");
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < 10; i++) {
                Toy toy = toyQueue.poll();
                writer.write("Выпала игрушка: " + toy.name + ", id: " + toy.id + "\n");
            }
            writer.close();
            System.out.println("Результаты записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}