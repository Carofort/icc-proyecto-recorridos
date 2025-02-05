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

        //if(findPath(grid, start.row, start.col, end, path, visitadas)){
          //          return path;
            //    }
        //return new ArrayList<>();

        findPath(maze, grid, start.row, start.col, end, start, path, visitadas);
        List<Cell> exploreList = new ArrayList<>(visitadas);
        return path.isEmpty()? exploreList : path;
    }

    private boolean findPath(Maze maze, boolean[][] grid, int row, int col, Cell end, Cell start, List<Cell> path, Set<Cell> visitadas) {
        Cell cell = new Cell(row, col);
        System.out.println(cell);

        if(row < 0 || col< 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]){
            System.out.println("hola");
            return false;
        }

        if(visitadas.contains(cell)){
            System.out.println("contiene");
             return false;
        }

        visitadas.add(cell);
        maze.updateMaze(cell, start, end);
        
        if(row == end.row && col == end.col){
            System.out.println("uuu");
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row + 1, col, end, start, path, visitadas)){
            System.out.println("baja fila");
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row, col + 1, end, start, path, visitadas)){
            System.out.println("derecha");
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row - 1, col, end, start, path, visitadas)){
            System.out.println("sube fila");
            path.add(cell);
            return true;
        }

        if(findPath(maze, grid, row, col - 1, end, start, path, visitadas)){
            System.out.println("izquierda");
            path.add(cell);
            return true;
        }
        System.out.println("acabo");
        //visitadas.remove(cell);
        path.remove(cell);
        return false;
    }
        
}
