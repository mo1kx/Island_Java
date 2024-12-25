class Island {
    int width;
    int height;
    Cell[][] grid;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];

        // Инициализация клеток
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void addAnimal(Animal animal) {
        // Добавляем животное в соответствующую клетку
        grid[animal.x][animal.y].addAnimal(animal);
    }

    public void growPlants() {
        // Проходим по всем клеткам и вызываем метод роста для растений
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j].plant.grow();
            }
        }
    }
}