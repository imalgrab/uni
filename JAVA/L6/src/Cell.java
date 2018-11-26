import java.util.ArrayList;
import java.util.Collections;

public class Cell {
    private boolean visited = false;

    private Cell northernNeighbour = null;
    private Cell southernNeighbour = null;
    private Cell easternNeighbour = null;
    private Cell westernNeighbour = null;

    private boolean northernWall = true;
    private boolean southernWall = true;
    private boolean easternWall = true;
    private boolean westernWall = true;

    public ArrayList<Cell> directNeighbours = new ArrayList<>();

    public void markAsVisited() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setNorthernNeighbour(Cell c) {
        northernNeighbour = c;
    }

    public Cell getNorthernNeighbour() {
        return northernNeighbour;
    }

    public void setSouthernNeighbour(Cell c) {
        southernNeighbour = c;
    }

    public Cell getSouthernNeighbour() {
        return southernNeighbour;
    }

    public void setEasternNeighbour(Cell c) {
        easternNeighbour = c;
    }

    public Cell getEasternNeighbour() {
        return easternNeighbour;
    }

    public void setWesternNeighbour(Cell c) {
        westernNeighbour = c;
    }

    public Cell getWesternNeighbour() {
        return westernNeighbour;
    }


    public void deleteNorthernWall() {
        northernWall = false;
    }

    public void deleteSouthernWall() {
        southernWall = false;
    }

    public void deleteEasternWall() {
        easternWall = false;
    }

    public void deleteWesternWall() {
        westernWall = false;
    }


    public boolean hasNorthernWall() {
        return northernWall;
    }

    public boolean hasSouthernWall() {
        return southernWall;
    }

    public boolean hasEasternWall() {
        return easternWall;
    }

    public boolean hasWesternWall() {
        return westernWall;
    }

    private void shuffleDirectNeighbours() {
        Collections.shuffle(directNeighbours);
    }

    public void setDirectNeighbours() {
        if (northernNeighbour != null) {
            directNeighbours.add(northernNeighbour);
        }
        if (southernNeighbour != null) {
            directNeighbours.add(southernNeighbour);
        }
        if (easternNeighbour != null) {
            directNeighbours.add(easternNeighbour);
        }
        if (westernNeighbour != null) {
            directNeighbours.add(westernNeighbour);
        }
        shuffleDirectNeighbours();
    }
}
