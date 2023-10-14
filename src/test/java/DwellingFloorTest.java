import Laba1.DwellingFloor;
import Laba1.Flat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DwellingFloorTest {

    Flat Flat1 = new Flat(16,4);//16 - 4
    Flat Flat2 = new Flat(25);// 25-2
    Flat Flat3 = new Flat(13,23); //13-23
    Flat[] DwFloor1 = new Flat[]{Flat1,Flat2,Flat3};
    DwellingFloor Stage1 = new DwellingFloor(DwFloor1);

    @Test
    void test_first_constructor(){
        //инициализация
        Flat flat = new Flat(50,2);
        int squareEx = 50;
        int quantityEx = 2;

        //вызов тестируемого метода
        int square = flat.getSquare();
        int quantity = flat.getQuantity();

        //проверка
        Assertions.assertEquals(squareEx,square);
        Assertions.assertEquals(quantityEx,quantity);
    }

    @Test
    void test_getTotalFlats(){
        var res = Stage1.getTotalFlats();

        Assertions.assertEquals(3,res);
    }

    @Test
    void test_getFlatsSquare(){
        var res = Stage1.getFlatsSquare();
        Assertions.assertEquals(54,res);
    }

    @Test
    void test_getFlatsQuantity(){
        var res = Stage1.getFlatsQuantity();
        Assertions.assertEquals(29,res);
    }

    @Test
    void test_getFlats(){//check
        Flat[] res = Stage1.getFlats();

        Assertions.assertEquals(DwFloor1,res);
    }

    @Test
    void test_getFlat(){
        var res = Stage1.getFlat(0);
        Assertions.assertEquals(Flat1,res);
    }

    @Test
    void test_setFlat(){
        Stage1.setFlat(2,Flat2);
        var res = Stage1.getFlat(2);
        Assertions.assertEquals(Flat2,res);
    }

    @Test
    void test_addFlat(){
        Stage1.addFlat(3,Flat1);
        var res = Stage1.getFlat(3);
        Assertions.assertEquals(Flat1,res);
    }

    @Test
    void test_deleteFlat(){
        Stage1.deleteFlat(1);//0-f1 1-f2 2-f3
        var res = Stage1.getFlat(1);
        Assertions.assertEquals(Flat3,res);
    }

    @Test
    void test_getBestSquare(){
        var res = Stage1.getBestSquare();
        Assertions.assertEquals(25,res.getSquare());
    }

    @Test
    void test_xd(){

    }

}
