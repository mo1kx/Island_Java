import java.util.List;

abstract class Herbivore extends Animal {
    public Herbivore(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    void eat(List<Animal> animalsInCell) {
        this.energy += 2; // Травоядные питаются растениями
    }
}