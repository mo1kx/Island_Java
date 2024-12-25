import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Wolf extends Predator {
    public Wolf(int x, int y) {
        super("Волк", x, y);
    }

    @Override
    void eat(List<Animal> animalsInCell) {
        for (Animal animal : new ArrayList<>(animalsInCell)) {
            if (animal instanceof Horse) { // Если в клетке есть лошадь
                if (new Random().nextInt(100) < 10) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 10; // Волк получает энергию за поедание
                    System.out.println(name + " съел лошадь!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Rabbit){
                if (new Random().nextInt(100) < 60) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 2; // Волк получает энергию за поедание
                    System.out.println(name + " съел кролика!");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Deer){
                if (new Random().nextInt(100) < 15) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 5; // Волк получает энергию за поедание
                    System.out.println(name + " съел оленя");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Goat) {
                if (new Random().nextInt(100) < 60) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 5; // Волк получает энергию за поедание
                    System.out.println(name + " съел козла");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Sheep) {
                if (new Random().nextInt(100) < 70) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 5; // Волк получает энергию за поедание
                    System.out.println(name + " съел овцу");
                    return; // Волк ест только одно животное за раз
                }
            }
            if (animal instanceof Hamster) {
                if (new Random().nextInt(100) < 80) { // 10% шанс
                    animalsInCell.remove(animal); // Убираем лошадь
                    this.energy += 2; // Волк получает энергию за поедание
                    System.out.println(name + " съел хомяка");
                    return; // Волк ест только одно животное за раз
                }
            }
        }


        // Если лошадей нет или шанс не сработал, волк теряет энергию
        this.energy -= 3;
    }

    @Override
    void reproduce(List<Animal> newAnimals, Island island) {
        if (new Random().nextInt(100) < 5) { // 5% шанс на размножение
            newAnimals.add(new Wolf(this.x, this.y));
        }
    }
}
