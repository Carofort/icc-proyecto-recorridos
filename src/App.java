import java.util.Arrays;
import java.util.List;

import controllers.MazeSolverBFS;
import controllers.MazeSolverDFS;
import controllers.MazeSolverDP;
import controllers.MazeSolverRecursivo;
import controllers.interfaces.MazeSolver;
import models.Cell;
import models.Maze;

public class App {
    public static void main(String[] args) throws Exception {
        
        boolean[][] laberinto = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true},

        };

        Maze maze = new Maze(laberinto);
        System.out.println("Laberinto: ");
        maze.printMaze();

        Cell start = new Cell(0,3);
        Cell end = new Cell(3,3);

        List<MazeSolver> soluciones = Arrays.asList(
            new MazeSolverRecursivo(),
            new MazeSolverBFS(),
            new MazeSolverDFS(),
            new MazeSolverDP(),
            new MazeSolverBFS());

            //Scanner selecciona la opcion 
            int opcion = 3;
            MazeSolver solver = soluciones.get(opcion - 1);
            List<Cell> path = solver.getPath(maze, laberinto, start, end);
            
            System.out.println("\n Camino encontrado:");
            System.out.println(path);

        System.out.println("Laberinto con camino");
        maze.printMazeWithPath(path);

    }
}
