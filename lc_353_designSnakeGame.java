package leetcode;
/* Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

 * 
 */
import java.util.*;
public class lc_353_designSnakeGame {
	private class Position{
        int x, y;   // height , width in matrix
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean gameOver;
    private int[][] food;
    private int score, width, height;
    private Set<Integer> usedMap;
    private Deque<Position> queue;
    
    public lc_353_designSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        gameOver = false;
        score = 0;
        usedMap = new HashSet<>();
        queue = new LinkedList<>();
        usedMap.add(0);     // first cell of snake
        queue.offer(new Position(0,0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (gameOver){
            return -1;
        }
        int xPlus = 0, yPlus = 0;
        switch(direction){
            case "U" : xPlus = -1; yPlus = 0; break;
            case "D" : xPlus = 1; yPlus = 0; break;
            case "L" : xPlus = 0; yPlus = -1; break;
            case "R" : xPlus = 0; yPlus = 1; break;
            default : break;
        }
        // get coordinate of new head
        int x = queue.peek().x + xPlus, y = queue.peek().y + yPlus;
        if (x >= 0 && x < height && y >= 0 && y < width){
            queue.offerFirst(new Position(x, y));
            if (score < food.length && x == food[score][0] && y == food[score][1]){
                score ++;
            }else{
                usedMap.remove(queue.peekLast().x * width + queue.peekLast().y);
                queue.pollLast();
            }
            // eat itself
            if (usedMap.contains(x * width + y)){
                gameOver = true;
                return -1;
            }else{
                usedMap.add(x * width + y);
            }
            return score;
        }else{
            gameOver = true;
            return -1;
        }
    }
}
