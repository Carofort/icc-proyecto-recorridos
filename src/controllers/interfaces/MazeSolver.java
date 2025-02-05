package controllers.interfaces;
import models.Cell;
import models.Maze;

import java.util.List;

public interface MazeSolver {
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end);
}
