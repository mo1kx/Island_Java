import java.util.*;

// Основной класс животных
abstract class Animal {
    String name;
    int x, y; // Координаты на острове
    int energy; // Энергия животного

    public Animal(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.energy = 10; // Начальная энергия
    }

    abstract void eat(List<Animal> animalsInCell);
    abstract void reproduce(List<Animal> newAnimals, Island island);

    void move(Island island) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1; // -1, 0, или 1
        int newY = y + random.nextInt(3) - 1;

        // Убедимся, что животное остается в пределах острова
        newX = Math.max(0, Math.min(island.width - 1, newX));
        newY = Math.max(0, Math.min(island.height - 1, newY));

        if (newX != x || newY != y) {
            // Перемещаем животное в новую клетку
            island.grid[x][y].animals.remove(this); // Удаляем из старой клетки
            island.grid[newX][newY].addAnimal(this); // Добавляем в новую клетку
            x = newX;
            y = newY;
        }
    }
}
