import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Snake extends Predator {
    public Snake(int x, int y) {
        super("Змея", x, y);
    }
    @Override
    void eat(List<Animal> animalsInCell) {
        for (Animal animal : new ArrayList<>(animalsInCell)) {
            if (animal instanceof Fox) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 15) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел Лису! +");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Rabbit) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 15) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел Кролика! +");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Hamster) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 20) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел Хомяка! +");
                    return; // Волк ест только одно животное за раз
                }
            }
        }
    }

    @Override
    void move(Island island) {
        this.x = Math.max(0, Math.min(island.width - 1, this.x + new Random().nextInt(3) - 1));
        this.y = Math.max(0, Math.min(island.height - 1, this.y + new Random().nextInt(3) - 1));
    }

    @Override
    void reproduce(List<Animal> newAnimals, Island island) {
        if (new Random().nextInt(100) < 15) { // 15% шанс на размножение
            newAnimals.add(new Snake(this.x, this.y));
        }
    }
}
