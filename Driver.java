public class Driver {
    public static void main(String[] args) {

        System.getProperties().list(System.out);
        
        GameArena arena = new GameArena(900, 500, true);
        // usually pool tables have a 2:1 ratio
        Rectangle theTable = new Rectangle(0, 0, 600, 300, "ORANGE", 1);
        arena.addRectangle(theTable);
        Ball testBall = new Ball(10, 20, 20, "BLUE", 2);
        arena.addBall(testBall);
        while (true) {
            arena.pause();
        }
    }
}