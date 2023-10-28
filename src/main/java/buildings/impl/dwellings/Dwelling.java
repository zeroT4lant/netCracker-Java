package buildings.impl.dwellings;

import buildings.impl.flats.Flat;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class Dwelling implements Building {
    Floor[] DwellingArr;//массив этажей

    public Dwelling(int stagesCount, int[] onStageCountOfFlats) {//good
        DwellingArr = new Floor[stagesCount];//новое строение с количеством этажей stagesCount
        for (int i = 0; i < stagesCount; i++) {
            DwellingArr[i] = new DwellingFloor(onStageCountOfFlats[i]);//количество квартир на этаже
        }
    }

    public Dwelling(Floor[] floors) {
        DwellingArr = floors;
    }

    public int getFloorsQuantity() {
        return DwellingArr.length;
    }

    public int getTotalFlats() {//общее количество квартир дома
        int sum = 0;
        for (int i = 0; i < DwellingArr.length; i++) {
            sum += DwellingArr[i].getTotalFlats();//количество квартир этажа
        }
        return sum;
    }

    public int getFlatsSquare() {//общая площадь квартир дома
        int sum = 0;
        for (int i = 0; i < DwellingArr.length; i++) {
            sum += DwellingArr[i].getFlatsSquare();//сумма площадей комнат всего этажа
        }
        return sum;
    }

    public int getFloorsQuatity() {//общее количество комнат дома
        int sum = 0;
        for (int i = 0; i < DwellingArr.length; i++) {
            sum += DwellingArr[i].getFlatsQuantity();//сумма комнат всего этажа
        }
        return sum;
    }

    public Floor[] getFloors() {
        return DwellingArr;
    }

    public Floor getFloor(int index) {
        return DwellingArr[index];
    }

    @Override
    public void setFloor(int index, Floor newFloor) {
        DwellingArr[index] = newFloor;
    }

    public Space getFlat(int index) {
        int room = 0;
        for (int i = 0; i < DwellingArr.length; i++) {
            for (int j = 0; j < DwellingArr[i].getFlats().length; j++) {
                if (room == index) {
                    return DwellingArr[i].getFlats()[j];
                }
                room++;
            }
        }
        return null;
    }

    public void setFlat(int index, Space newFlat) {
        int room = 0;
        for (int i = 0; i < DwellingArr.length; i++) {
            for (int j = 0; j < DwellingArr[i].getFlats().length; j++) {
                if (room == index) {
                    DwellingArr[i].getFlats()[j] = newFlat;
                }
                room++;
            }
        }
    }

    public void addFlat(int index, Space newFlat) {
        int currentFloor = 0;
        for (Floor floor : DwellingArr) {//перебор этажей
            int totalFlatsOnFloor = floor.getTotalFlats();//получение массива квартир
            if (index <= currentFloor + totalFlatsOnFloor) {//когда достигаем последнего этажа
                floor.addFlat(index - currentFloor, newFlat);//добавляем квартиру
                break;
            }
            currentFloor += totalFlatsOnFloor;
        }
    }

    public void deleteFlat(int index) {
        int currentFloor = 0;
        for (Floor floor : DwellingArr) {//перебор этажей
            int totalFlatsOnFloor = floor.getTotalFlats();//получение массива квартир(этаж)
            if (index < currentFloor + totalFlatsOnFloor) {
                floor.deleteFlat(index - currentFloor);
                break;
            }
            currentFloor += totalFlatsOnFloor;
        }
    }

    public Space getBestFlatBySquare() {
        if (getFloorsQuatity() == 0) {
            return null;
        }
        Space bestFlat = getFlat(0);
        for (int i = 1; i < DwellingArr.length; i++) {
            Space curFlat = getFlat(i);
            if (curFlat.getSquare() > bestFlat.getSquare()) {
                bestFlat = curFlat;
            }

        }
        return bestFlat;
    }

    public Space[] getSortFlatsBySquare(int order){
        int totalFlats = getTotalFlats();
        Flat[] flats = new Flat[totalFlats];
        int flatsLen = flats.length;

        int currentIndex = 0;
        for (Floor floor : DwellingArr) {
            Space[] floorFlats = floor.getFlats();
            System.arraycopy(floorFlats, 0, flats, currentIndex, floorFlats.length);
            currentIndex += floorFlats.length;
        }

        for (int i = 0; i < flatsLen - 1; i++) {
            for (int j = 0; j < flatsLen - i - 1; j++) {
                double flatsLowPrev = flats[j].getSquare(), flatsHighNext = flats[j + 1].getSquare();

                if (order == 1 && flatsLowPrev > flatsHighNext) {
                    Flat temp = flats[j];
                    flats[j] = flats[j + 1];
                    flats[j + 1] = temp;
                } else if (order == 0 && flatsLowPrev < flatsHighNext) {
                    Flat temp = flats[j];
                    flats[j] = flats[j + 1];
                    flats[j + 1] = temp;
                }
            }
        }

        return flats;

    }

}


