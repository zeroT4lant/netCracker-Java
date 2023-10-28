package buildings.interfaces;

public interface Building {
    int getFloorsQuantity();
    int getTotalFlats();
    int getFlatsSquare();
    int getFloorsQuatity();
    Floor[] getFloors();
    Floor getFloor(int index);
    void setFloor(int index, Floor newFloor);
    Space getFlat(int index);
    void setFlat(int index, Space newSpace);
    void addFlat(int index, Space newSpace);
    void deleteFlat(int index);
    Space getBestFlatBySquare();
    Space[] getSortFlatsBySquare(int order);
}
