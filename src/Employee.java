/**
 * Класс, который содержит описание сущности работника
 */

public class Employee {
    int id;
    String name;
    String gender;
    String birthDay;
    Department division;
    int salary;

    /**
     * Методы, позволяющие получить значения каждого поля
     */
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public String getBirthDay(){
        return birthDay;
    }
    public Department getDivision(){
        return division;
    }
    public int getSalary(){
        return salary;
    }

    /**
     * Методы, позволяющие установить значения для каждого поля
     */
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public void setBirthDay(String birthDay){
        this.birthDay=birthDay;
    }
    public void setDivision(Department division){
        this.division=division;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }

}
