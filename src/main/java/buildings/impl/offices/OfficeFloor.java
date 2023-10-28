package buildings.impl.offices;

import buildings.impl.flats.Flat;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class OfficeFloor implements Floor {
    Space[] offices;
    public OfficeFloor (int flatCount){//в аргументе количество квартир
        offices = new Flat[flatCount];
        for (int i = 0;i<flatCount;i++){
            offices[i] = new Flat();// на i-ый элемент массива будет вызван конструктор
        }
    }

    public OfficeFloor(Flat[] flatArr){//в аргументе сами квартиры
        offices = flatArr;
    }

    public int getTotalFlats(){
        return offices.length;
    }

    public int getFlatsSquare(){
        int sum = 0;
        for (int i = 0;i<offices.length;i++){
            sum += offices[i].getSquare();
        }
        return sum;
    }

    public int getFlatsQuantity() {
        int sumQuantity = 0;
        for (int i = 0;i < offices.length;i++){
            sumQuantity += offices[i].getQuantity();
        }
        return sumQuantity;
    }

    public Space[] getFlats() {
        return offices;
    }

    public Space getFlat(int index){
        return offices[index];
    }

    @Override
    public void setFlat(int index, Space newFlat) {
        if (index <= offices.length){
            offices[index] = newFlat;
        }else {
            System.out.println("Вышли за предел массива");
        }
    }

    @Override
    public void addFlat(int index, Space newFlat) {
        if (index > offices.length-1){
            Space[] newArr = new Space[index+1];
            for (int i = 0;i<offices.length;i++){
                newArr[i] = offices[i];
            }
            newArr[index] = newFlat;//добавляем новый элемент
            offices = newArr;
        }
    }

    public void deleteFlat(int index){
        Space[] newFlats = new Space[offices.length - 1];
        for (int i = 0, j = 0; i < offices.length; i++) {
            if (i != index) {
                newFlats[j] = offices[i];
                j++;
            }
        }
        offices = newFlats;
    }

    public Space getBestSquare(){
        Space bestFlat = getFlat(0);
        for (Space room : offices){
            if (room.getSquare() > bestFlat.getSquare()){
                bestFlat = room;
            }
        }
        return bestFlat;
    }
}
