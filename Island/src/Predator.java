import java.util.List;
import java.util.Optional;

abstract class Predator extends Animal {
    public Predator(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    void eat(List<Animal> animalsInCell) {
        // Ищем травоядных в текущей клетке
        Optional<Animal> prey = animalsInCell.stream()
                .filter(animal -> animal instanceof Herbivore)
                .findFirst();
        prey.ifPresent(animal -> {
            animalsInCell.remove(animal); // Удаляем травоядного
            this.energy += 5; // Восстанавливаем энергию
            System.out.println(this.name + " съел " + animal.name);
        });
    }
}
