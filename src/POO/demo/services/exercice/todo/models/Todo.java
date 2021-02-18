package POO.demo.services.exercice.todo.models;

public class Todo implements Model {

    public enum Difficulty{
        EASY(10),
        MEDIUM(30),
        HARD(60);

        Difficulty(int expectedTime) {
            this.expectedTime = expectedTime;
        }

        private final int expectedTime;

        public int getExpectedTime() {
            return expectedTime;
        }

        @Override
        public String toString() {
            return "Difficulty{" +
                    "expectedTime=" + expectedTime +
                    '}';
        }
    }

    private int id;
    private String name;
    private Difficulty difficulty;

    public Todo(int id, String name, Difficulty difficulty) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override // enum size = 3    [0;2]
    public String toString() {
        StringBuilder difficulty = new StringBuilder("[");
        int enumSize = Difficulty.values().length;

        for (int i = 0; i < enumSize; i++) {
            if(i <= this.getDifficulty().ordinal())
                difficulty.append('*');
            else
                difficulty.append('-');
        }

        difficulty.append( "], temps attendu : " )
                .append( this.getDifficulty().getExpectedTime() )
                .append("min");
        
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficulty= " + difficulty +
                '}';
    }

}
