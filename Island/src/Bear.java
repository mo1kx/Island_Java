import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Bear extends Predator {
    public Bear(int x, int y) {
        super("Медведь", x, y);
    }
    @Override
    void eat(List<Animal> animalsInCell) {
        for (Animal animal : new ArrayList<>(animalsInCell)) {
            if (animal instanceof Snake) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 80) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел змею!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Horse) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 40) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел лошадь!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Deer) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 80) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел Оленя!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Rabbit) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 80) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел кролика!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Hamster) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 90) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел хомяка!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Goat) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 70) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел козла!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Sheep) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 70) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел овцу!");
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
            newAnimals.add(new Bear(this.x, this.y));
        }
    }
}
