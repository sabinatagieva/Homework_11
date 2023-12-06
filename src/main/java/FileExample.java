import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        // Создание папки
        File directory = new File("myFolder");
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Папка создана");
        }

        // Создание двух файлов в папке
        File file1 = new File(directory, "file1.txt");
        File file2 = new File(directory, "file2.txt");

        try {
            if (file1.createNewFile() && file2.createNewFile()) {
                System.out.println("Файлы созданы");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запись фразы в первый файл
        try (FileWriter writer = new FileWriter(file1)) {
            writer.write("Java World");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение из первого файла и запись во второй
        try (FileReader reader = new FileReader(file1);
             FileWriter writer = new FileWriter(file2)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Удаление файлов и папки
        file1.delete();
        file2.delete();
        directory.delete();
    }
}

