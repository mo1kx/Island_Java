class Plant {
    int growthStage; // Текущая стадия роста
    final int MAX_GROWTH_STAGE = 5; // Максимальная стадия роста

    public Plant() {
        this.growthStage = 0; // Начальная стадия роста
    }

    // Метод для роста растения
    void grow() {
        if (growthStage < MAX_GROWTH_STAGE) {
            growthStage++;
        }
    }

    // Метод для получения информации о стадии роста
    public int getGrowthStage() {
        return growthStage;
    }

    // Метод для проверки, можно ли есть растение
    public boolean isEdible() {
        return growthStage >= 3; // Например, растение съедобно, если его стадия роста >= 3
    }

    // Метод для получения символа, представляющего растение
    public String getSymbol() {
        switch (growthStage) {
            case 0: return "🌱"; // Начальная стадия
            case 1: return "🌿"; // Первая стадия
            case 2: return "🌾"; // Вторая стадия
            case 3: return "🌳"; // Третья стадия
            case 4: return "🌲"; // Четвертая стадия
            case 5: return "🌴"; // Пятая стадия
            default: return "?"; // На всякий случай
        }
    }
}