package buildings.impl.dwellings;

import buildings.impl.flats.Flat;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class DwellingFloor implements Floor {
    Space[] DwellingFloorArr;
    public DwellingFloor (int flatCount){//в аргументе количество квартир
        DwellingFloorArr = new Flat[flatCount];
        for (int i = 0;i<flatCount;i++){
            DwellingFloorArr[i] = new Flat();// на i-ый элемент массива будет вызван конструктор
        }
    }

    public DwellingFloor(Space[] flatArr){//в аргументе сами квартиры
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

    public Space[] getFlats() {
        return DwellingFloorArr;
    }

    public Space getFlat(int index){
        return DwellingFloorArr[index];
    }

    @Override
    public void setFlat(int index, Space newFlat) {
        if (index <= DwellingFloorArr.length){
            DwellingFloorArr[index] = newFlat;
        }else {
            System.out.println("Вышли за предел массива");
        }
    }

    @Override
    public void addFlat(int index, Space newFlat) {
        if (index > DwellingFloorArr.length-1){
            var newArr = new Space[index+1];
            for (int i = 0;i<DwellingFloorArr.length;i++){
                newArr[i] = DwellingFloorArr[i];
            }
            newArr[index] = newFlat;//добавляем новый элемент
            DwellingFloorArr = newArr;
        }
    }

    public void deleteFlat(int index){
        Space[] newFlats = new Space[DwellingFloorArr.length - 1];
        for (int i = 0, j = 0; i < DwellingFloorArr.length; i++) {
            if (i != index) {
                newFlats[j] = DwellingFloorArr[i];
                j++;
            }
        }
        DwellingFloorArr = newFlats;
    }

    public Space getBestSquare(){
        Space bestFlat = getFlat(0);
        for (Space room : DwellingFloorArr){
            if (room.getSquare() > bestFlat.getSquare()){
                bestFlat = room;
            }
        }
        return bestFlat;
    }

}
