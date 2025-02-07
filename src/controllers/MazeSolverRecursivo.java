package controllers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import controllers.interfaces.MazeSolver;
import models.Cell;
import models.Maze;

public class MazeSolverRecursivo implements MazeSolver{

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new LinkedHashSet();
        if(grid == null || grid.length == 0){
            return path;
        }

        findPath(maze, grid, start.row, start.col, end, start, path, visitadas);
        List<Cell> exploreList = new ArrayList<>(visitadas);
        return path.isEmpty()? exploreList : path;
    }

    private boolean findPath(Maze maze, boolean[][] grid, int row, int col, Cell end, Cell start, List<Cell> path, Set<Cell> visitadas) {
        Cell cell = new Cell(row, col);
        System.out.println(cell);

        if(row < 0 || col< 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]){
            return false;
        }

        if(visitadas.contains(cell)){
             return false;
        }

        visitadas.add(cell);
        maze.updateMaze(cell, start, end);
        
        if(row == end.row && col == end.col){
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row + 1, col, end, start, path, visitadas)){
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row, col + 1, end, start, path, visitadas)){
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row - 1, col, end, start, path, visitadas)){
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row, col - 1, end, start, path, visitadas)){
            path.add(cell);
            return true;
        }

        path.remove(cell);
        return false;
    }
        
}
