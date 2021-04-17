import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.util.*;

/**
 * Класс, содержащий функционал для считывания файлов и формирования списка с данными
 */
public class ReadInList {

    static private int id = 1;

    /**
     * Метод, с помощью которого происходит считывание файла и формирование списка
     * @param path - путь к файлу
     * @return список с сущностями типа Employee
     * @throws Exception в случае, если файл не найден
     */

    static public ArrayList<Employee> makeList(String path) throws Exception{
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Department> departments = new ArrayList<Department>();
        int id=1;
        try {
            FileReader reader = new FileReader(path);
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
                if (csvReader == null) {
                    throw new FileNotFoundException(path);
                }
                String[] nextLine;
                nextLine = csvReader.readNext();
                while ((nextLine = csvReader.readNext()) != null){
                    if (nextLine!=null){
                        employees.add(createNew(nextLine, departments));
                    }
                }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return employees;
    }

    /**
     * Метод, создающий объект типа Employee по значениям, считанным из очередной строки
     * @param line - распарсенная строка
     * @param list - список подразделений
     * @return объект типа Employee
     */
    static private Employee createNew(String[] line, ArrayList<Department> list){
        Employee temp = new Employee();
        temp.setId(Integer.parseInt(line[0]));
        temp.setName(line[1]);
        temp.setGender(line[2]);
        temp.setBirthDay(line[3]);
        temp.setDivision(find(list, line[4]));
        temp.setSalary(Integer.parseInt(line[5]));
        return temp;
    }

    /**
     * Метод, отыскивающий в передаваемом списке нужное подразделение
     * если такого подразделения нет, создается новое и добавляется в список
     * @param departments - список текущих используемых подразделений
     * @param division - подразделение, которое нужно отыскать
     * @return объект с искомым подразделением
     */
    static private Department find(List<Department> departments, String division){
        Department temp = departments.stream()
                .filter(a -> division.equals(a.getDepName())).findFirst()
                .orElse(null);
        if (temp==null){
            temp = new Department();
            temp.setDepName(division);
            temp.setId(id);
            departments.add(temp);
            id++;
        }
        return temp;
    }
}
