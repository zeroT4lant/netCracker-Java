package Laba1;

import java.util.Arrays;

public class Dwelling {
    DwellingFloor[] DwellingArr;//массив этажей

    public Dwelling(int stagesCount, int[] onStageCountOfFlats) {//good
        DwellingArr = new DwellingFloor[stagesCount];//новое строение с количеством этажей stagesCount
        for (int i = 0; i < stagesCount; i++) {
            DwellingArr[i] = new DwellingFloor(onStageCountOfFlats[i]);//количество квартир на этаже
        }
    }

    public Dwelling(DwellingFloor[] floors) {
        DwellingArr = floors;
    }

    public int getDwellingFloorQuantity() {
        return DwellingArr.length;
    }

    public int getFlatsQuantity() {//общее количество квартир дома
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

    public int getRoomsQuantity() {//общее количество комнат дома
        int sum = 0;
        for (int i = 0; i < DwellingArr.length; i++) {
            sum += DwellingArr[i].getFlatsQuantity();//сумма комнат всего этажа
        }
        return sum;
    }

    public DwellingFloor[] getDwellingFloors() {
        return DwellingArr;
    }

    public DwellingFloor getDwellingFloor(int index) {
        return DwellingArr[index];
    }

    public void setDwellingFloor(int index, DwellingFloor newDwellingFloor) {
        DwellingArr[index] = newDwellingFloor;
    }

    public Flat getFlat(int index) {
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

    public void setFlat(int index, Flat newFlat) {
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

    public void addFlat(int index, Flat newFlat) {
        int currentFloor = 0;
        for (DwellingFloor floor : DwellingArr) {//перебор этажей
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
        for (DwellingFloor floor : DwellingArr) {//перебор этажей
            int totalFlatsOnFloor = floor.getTotalFlats();//получение массива квартир(этаж)
            if (index < currentFloor + totalFlatsOnFloor) {
                floor.deleteFlat(index - currentFloor);
                break;
            }
            currentFloor += totalFlatsOnFloor;
        }
    }

    public Flat getBestFlatBySquare() {
        if (getFlatsQuantity() == 0) {
            return null;
        }
        Flat bestFlat = getFlat(0);
        for (int i = 1; i < DwellingArr.length; i++) {
            Flat curFlat = getFlat(i);
            if (curFlat.getSquare() > bestFlat.getSquare()) {
                bestFlat = curFlat;
            }

        }
        return bestFlat;
    }

//    public Flat[] flattendArr(){//преобразование в одномерный массив
//        Flat[] newFlatsArr = new Flat[getFlatsQuantity()];//проверить получение всех квартир
//    }

    public Flat[] getSortFlatsBySquare(int order){
        if (getFlatsQuantity() == 0) {
            return new Flat[0];
        }
        Flat[] sortedFlats = Arrays.copyOf(getDwellingFloors()[0].getFlats(), getFlatsQuantity());

        for (int i = 0; i < getFlatsQuantity() - 1; i++) {
            for (int j = 0; j < getFlatsQuantity() - i - 1; j++) {
                if (order == 1) {
                    if (sortedFlats[j].getSquare() > sortedFlats[j + 1].getSquare()) {
                        Flat temp = sortedFlats[j];
                        sortedFlats[j] = sortedFlats[j + 1];
                        sortedFlats[j + 1] = temp;
                    }
                } else if (order == -1) {
                    if (sortedFlats[j].getSquare() < sortedFlats[j + 1].getSquare()) {
                        Flat temp = sortedFlats[j];
                        sortedFlats[j] = sortedFlats[j + 1];
                        sortedFlats[j + 1] = temp;
                    }
                }
            }
        }

        return sortedFlats;

    }
    //----------------------------------------------------------
//    if (getFlatsQuantity() == 0) {
//        return new Flat[0];
//    }
//    Flat[] sortedFlats = Arrays.copyOf(getDwellingFloors()[0].getFlats(), getFlatsQuantity());
//
//        for (int i = 0; i < getFlatsQuantity() - 1; i++) {
//        for (int j = 0; j < getFlatsQuantity() - i - 1; j++) {
//            if (order == 1) {
//                if (sortedFlats[j].getSquare() > sortedFlats[j + 1].getSquare()) {
//                    Flat temp = sortedFlats[j];
//                    sortedFlats[j] = sortedFlats[j + 1];
//                    sortedFlats[j + 1] = temp;
//                }
//            } else if (order == -1) {
//                if (sortedFlats[j].getSquare() < sortedFlats[j + 1].getSquare()) {
//                    Flat temp = sortedFlats[j];
//                    sortedFlats[j] = sortedFlats[j + 1];
//                    sortedFlats[j + 1] = temp;
//                }
//            }
//        }
//    }
//
//        return sortedFlats;


}


