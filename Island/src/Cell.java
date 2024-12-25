import java.util.ArrayList;
import java.util.List;

class Cell {
    List<Animal> animals;
    Plant plant;

    public Cell() {
        this.animals = new ArrayList<>();
        this.plant = new Plant(); // Инициализация растения
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    // Метод для получения символа клетки
    public String getCellSymbol() {
        if (!animals.isEmpty()) {
            return animals.size() > 1 ? "🦣" : IslandSimulation.getAnimalSymbol(animals.get(0));
        } else if (plant != null && plant.getGrowthStage() > 0) {
            return plant.getSymbol();
        } else {
            return ".";
        }
    }
}