package online.opencart_automation.managers;

import com.github.javafaker.Faker;

public class DataGeneratorManager {
    private static Faker faker = new Faker();

    public static String getRandomEmail (){
        return faker.internet().emailAddress();
    }

    public static String getRandomUsername(){
        return faker.name().username();
    }

    public static String getRandomPass(int min, int max){
        return faker.internet().password(min,max);
    }

    public static String getRandomFirstName(){
        return  faker.name().firstName();
    }
    public static String getRandomLastName(){
        return  faker.name().lastName();
    }

    public static String getRandomMiddleName(){
        return  faker.name().name();
    }

    public  static String getRandomNotes(){
        return getRandomFirstName();
    }

    public  static String getRandomKeyword(){
        return getRandomFirstName();
    }



}
