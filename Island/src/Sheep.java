import java.util.List;
import java.util.Random;

class Sheep extends Herbivore {
    public Sheep(int x, int y) {
        super("Овца", x, y);
    }

    @Override
    void move(Island island) {
        this.x = Math.max(0, Math.min(island.width - 1, this.x + new Random().nextInt(3) - 1));
        this.y = Math.max(0, Math.min(island.height - 1, this.y + new Random().nextInt(3) - 1));
    }

    @Override
    void reproduce(List<Animal> newAnimals, Island island) {
        if (new Random().nextInt(100) < 10) { // 10% шанс на размножение
            newAnimals.add(new Sheep(this.x, this.y));
        }
    }
}