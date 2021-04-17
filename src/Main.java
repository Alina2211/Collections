import java.util.ArrayList;
/**
 * Программа, позволяющая из файла получить список сущностей
 * @author Губина Алина
 */

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Employee> list = ReadInList.makeList("./src/foreign_names.csv");
    }
}
