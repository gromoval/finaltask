import decorators.DataSourceDecorator;
import decorators.FileDataSource;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestCSV {


    /**
     * Метод для получения данных из csv
     */
    @DataProvider
    public static Object[] usingCSV() {
//        String csvFile = "target/data.csv"; //на данный момент решили поместить файл в папку resources
        String csvFile = "src/main/resources/data.csv";
        String line;
        String csvSplitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                Object[] arr1 = line.split(csvSplitBy);
                return arr1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[]{};
    }

    /**
     * Метод для вывода данных из csv
     */

    public static void main(String[] args) {
        String csvFile = "src/main/resources/data.csv";
        String line = null;
        String csvSplitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                Object[] o = line.split(csvSplitBy);
                List<Object> list = Arrays.asList(o);
//                System.out.println(list);
//                Разные способы вывода данных: //коммент оставлен т.к. еще ведется работа над методом
//                System.out.println(o[0]);
//               System.out.println(Arrays.toString(o));
//                for (int i = 0; i < o.length; i++) {
//                    System.out.println(o[i]);
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод для вывода данных из файла с использованием паттерна Декоратор
     */
/*
    public static void main(String[] args) {
        String name = "src/main/resources/test.csv";
        DataSourceDecorator test = new DataSourceDecorator(new FileDataSource(name));
        System.out.println(test.readData());
    }
 */

    /**
     * Заготовка метода для получения данных из файла с использованием паттерна Декоратор
     */

//    @DataProvider
//    public static Object[] usingDecorator(){ }

    /**
     * Тест для проверки использования данных
     */
    @Test(dataProvider = "usingCSV")
    public void testCsvS(String s) {
        String res = "приветик";
        Assert.assertEquals(s, res, "Тест не пройден");
        System.out.println("Тест пройден:\n" + "Ожидаемый результат " + s + ", Фактический результат " + res);
    }
}
