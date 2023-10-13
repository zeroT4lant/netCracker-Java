package Laba1;

public class DwellingFloor {
    Flat[] DwellingFloorArr;
    public DwellingFloor (int flatCount){//в аргументе количество квартир
        DwellingFloorArr = new Flat[flatCount];
        for (int i = 0;i<flatCount;i++){
            DwellingFloorArr[i] = new Flat();// на i-ый элемент массива будет вызван конструктор
        }
    }

    public DwellingFloor(Flat[] flatArr){//в аргументе сами квартиры
        DwellingFloorArr = flatArr;
    }

    public int getTotalFlats(){
        return DwellingFloorArr.length;
    }

    public int getFlatsSquare(){
        int sum = 0;
        for (int i = 0;i<DwellingFloorArr.length;i++){
            sum += DwellingFloorArr[i].getSquare();
        }
        return sum;
    }

    public int getFlatsQuantity() {
        int sumQuantity = 0;
        for (int i = 0;i < DwellingFloorArr.length;i++){
            sumQuantity += DwellingFloorArr[i].getQuantity();
        }
        return sumQuantity;
    }

    public Flat[] getFlats() {
        return DwellingFloorArr;
    }

    public Flat getFlat(int index){
        return DwellingFloorArr[index];
    }

    public void setFlat(int index,Flat newFlat){
        if (index <= DwellingFloorArr.length){
            DwellingFloorArr[index] = newFlat;
        }else {
            System.out.println("Вышли за предел массива");
        }
    }


    //work!!!
    public void addFlat(int index,Flat newFlat){//добавление квартиры по индексу - работает по этажу
        if (index > DwellingFloorArr.length-1){
            var newArr = new Flat[index+1];
            for (int i = 0;i<DwellingFloorArr.length;i++){
                newArr[i] = DwellingFloorArr[i];
            }
            newArr[index] = newFlat;//добавляем новый элемент
            DwellingFloorArr = newArr;
        }
    }

    public void deleteFlat(int index){
        Flat[] newFlats = new Flat[DwellingFloorArr.length - 1];
        for (int i = 0, j = 0; i < DwellingFloorArr.length; i++) {
            if (i != index) {
                newFlats[j] = DwellingFloorArr[i];
                j++;
            }
        }
        DwellingFloorArr = newFlats;
    }

    public Flat getBestSquare(){
        Flat bestFlat = getFlat(0);
        for (Flat room : DwellingFloorArr){
            if (room.getSquare() > bestFlat.getSquare()){
                bestFlat = room;
            }
        }
        return bestFlat;
    }

}
