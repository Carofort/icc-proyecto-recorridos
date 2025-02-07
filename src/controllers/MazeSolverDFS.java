package controllers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import controllers.interfaces.MazeSolver;
import models.Cell;
import models.Maze;

public class MazeSolverDFS  implements MazeSolver {
    Set<Cell> visited = new LinkedHashSet<>();

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        System.out.println("Laberinto con DFS");
        List<Cell> path = new ArrayList<>();
        if(dfs(grid, start.row, start.col, end, path))
            return path;
        return new ArrayList<>();
    } 

    private boolean dfs(boolean[][] grid, int row, int col, Cell end, List<Cell> path) {
        Cell cell = new Cell(row, col);
        if(!isValid(grid, row, col) || visited.contains(cell)){
            return false;
        }
        visited.add(cell);
        path.add(cell);

        if(cell.equals(end)){
            return true;
        }

        if(dfs(grid, row + 1, col, end, path) || dfs(grid, row, col + 1, end, path) ||
                dfs(grid, row - 1, col, end, path) || dfs(grid, row, col - 1, end, path)){
            return true;
        }

        path.remove(cell);
        return false;
    }

    private boolean isValid(boolean[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col];
    }      
}
