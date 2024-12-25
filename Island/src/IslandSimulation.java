import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandSimulation {

    public static void main(String[] args) throws InterruptedException {
        SimulationParams params = new SimulationParams();
        Island island = new Island(params.islandWidth, params.islandHeight);

        Random random = new Random();
        // Инициализация острова
        for (int i = 0; i < params.animalCount / 2; i++) {
            island.addAnimal(new Deer(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Wolf(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Rabbit(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Cow(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Horse(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Caterpillar(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Kangaroo(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Hamster(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Sheep(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Goat(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Snake(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Eagle(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Fox(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
            island.addAnimal(new Bear(random.nextInt(params.islandWidth), random.nextInt(params.islandHeight)));
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> updateIsland(island, params), 0, params.tickDuration, TimeUnit.MILLISECONDS);
    }
    public static void printIsland(Island island) {
        for (int i = 0; i < island.width; i++) {
            for (int j = 0; j < island.height; j++) {
                Cell cell = island.grid[i][j];
                if (!cell.animals.isEmpty()) {
                    System.out.print(cell.animals.size() > 1 ? "🦣" : getAnimalSymbol(cell.animals.get(0)));
                } else if (cell.plant != null && cell.plant.growthStage > 0) {
                    System.out.print("🌱");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String getAnimalSymbol(Animal animal) {
        if (animal instanceof Deer) return "🦌";
        if (animal instanceof Wolf) return "🐺";
        if (animal instanceof Rabbit) return "\uD83D\uDC07";
        if (animal instanceof Cow) return "\uD83D\uDC04";
        if (animal instanceof Horse) return "\uD83D\uDC0E";
        if (animal instanceof Caterpillar) return "\uD83D\uDC1B";
        if (animal instanceof Kangaroo) return "\uD83E\uDD98";
        if (animal instanceof Hamster) return "\uD83D\uDC39";
        if (animal instanceof Sheep) return "\uD83D\uDC11";
        if (animal instanceof Goat) return "\uD83D\uDC10";
        if (animal instanceof Snake) return "\uD83D\uDC0D";
        if (animal instanceof Eagle) return "\uD83E\uDD85";
        if (animal instanceof Fox) return "\uD83E\uDD8A";
        if (animal instanceof Bear) return "\uD83D\uDC3B";
        return "?";
    }

    public static void updateIsland(Island island, SimulationParams params) {
        List<Animal> newAnimals = new ArrayList<>();

        // Обработка жизненного цикла
        for (int i = 0; i < island.width; i++) {
            for (int j = 0; j < island.height; j++) {
                Cell cell = island.grid[i][j];

                // Животные в клетке
                for (Animal animal : new ArrayList<>(cell.animals)) {
                    animal.eat(cell.animals);
                    animal.move(island);
                    animal.reproduce(newAnimals, island);
                }
            }
        }

        // Добавляем новых животных
        for (Animal animal : newAnimals) {
            island.addAnimal(animal);
        }

        // Растение растет
        island.growPlants();

        // Вывод острова
        printIsland(island);
    }
}