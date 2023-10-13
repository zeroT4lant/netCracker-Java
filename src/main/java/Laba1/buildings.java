package Laba1;

import java.util.Arrays;

public class buildings {
    public static void main(String[] args) {

        Flat Flat1 = new Flat(16,4);//50 - 2
        Flat Flat2 = new Flat(25);// 20-2
        Flat Flat3 = new Flat(13,23); //11-23
        Flat Flat4 = new Flat(133,23);
        Flat Flat5 = new Flat(228,23);

        Flat[] DwFloor1 = new Flat[]{Flat1,Flat2,Flat3};//work getSquare
        Flat[] DwFloor2 = new Flat[]{Flat3,Flat2,Flat1};
        Flat[] DwFloor3 = new Flat[]{Flat2,Flat1,Flat3};
        Flat[] newFloor = new Flat[]{Flat1,Flat2,Flat4};

        DwellingFloor Stage1 = new DwellingFloor(DwFloor1);
        DwellingFloor Stage2 = new DwellingFloor(DwFloor2);
        DwellingFloor Stage3 = new DwellingFloor(DwFloor3);
        DwellingFloor Stage4 = new DwellingFloor(newFloor);

        var arrayOfStages = new DwellingFloor[]{Stage1,Stage2,Stage3};

        Dwelling testDwelling = new Dwelling(arrayOfStages);

        System.out.println("Количество этажей дома: "+ testDwelling.getDwellingFloorQuantity());//work
        System.out.println("Количество квартир дома: " + testDwelling.getFlatsQuantity());//work
        System.out.println("Общее площадь квартир дома: " + testDwelling.getFlatsSquare());
        System.out.println("Общее количество комнат дома: " + testDwelling.getRoomsQuantity());
        System.out.println("Для получения массива этажей дома: " + Arrays.toString(testDwelling.getDwellingFloors()));
        System.out.println("Получение объекта этажа по номеру в доме: " + testDwelling.getDwellingFloor(1));
        testDwelling.setDwellingFloor(2,Stage4);
        System.out.println("Новый массив этажей: " + Arrays.toString(testDwelling.getDwellingFloors()));
        System.out.println("Получаем квартиру по номеру: " + testDwelling.getFlat(8));//9 квартир всего
        System.out.println("Квартира до изменения "+ testDwelling.getFlat(0));
        testDwelling.setFlat(0,Flat4);
        System.out.println("Квартира после изменения "+ testDwelling.getFlat(0));
        //---------------------------------------------------
        System.out.println("-------------------------------------");
        System.out.println("Проверяем 9 индекс: "+testDwelling.getFlat(9));
        System.out.println("Добавляем 9 индекс...");
        testDwelling.addFlat(9,Flat5);
        System.out.println("Проверяем 9 индекс: "+testDwelling.getFlat(9));
        System.out.println("Проверяем 4 индекс: "+ testDwelling.getFlat(4));
        System.out.println("Удаляем 4 индекс...");
        testDwelling.deleteFlat(4);
        System.out.println("Квартира после удаления "+ testDwelling.getFlat(4));
        System.out.println("Самая большая по площади квартира: " + testDwelling.getBestFlatBySquare());


        Flat[] sortedFlats = testDwelling.getSortFlatsBySquare(0);
        System.out.println("Квартиры, отсортированные по убыванию площади:");
        for (Flat flat : sortedFlats) {
            System.out.println("Площадь = " + flat.getSquare() + " кв.м, Количество комнат = " + flat.getQuantity());
        }

    }
}
