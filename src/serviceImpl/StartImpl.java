package serviceImpl;

import DataBase.Db;
import service.Start;

import java.time.LocalTime;

public  class StartImpl implements Start {

    @Override
    public String times() {

        LocalTime now=LocalTime.now();
        int house=now.getHour();

        if (house>=4&&house<11){
            return "Доброе утро "+now.withSecond(0).withNano(0);
        } else if (house>=11&&house<19) {
            return "Добрый день "+now.withSecond(0).withNano(0);
        }else  {
            return "Добрый вечер " + now.withSecond(0).withNano(0);
        }
    }

    @Override
    public boolean login(String konsoleEmail, String konsolePassword) {

        try {
            if (konsoleEmail == null||konsolePassword==null||konsoleEmail.isBlank()||konsolePassword.isBlank()) {
                throw new NullPointerException("Название  урока не должен быть null!");
            }
if (Db.email.equals(konsoleEmail)&&Db.password.equals(konsolePassword)){
    System.out.println("Вы успешно зашли!");
    return true;
}System.out.println("Не правилный порол или email!");
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("(T_T)<(^-^<)");
        }

        return false;
    }

    @Override
    public void updateLogin(String konsoleEmail, String newPassword) {
        try {
            if (konsoleEmail == null||newPassword==null||konsoleEmail.isBlank()||newPassword.isBlank()) {
                throw new NullPointerException("Название  урока не должен быть null!");
            }
            if (konsoleEmail.equals(Db.email)){
                Db.password=newPassword;
            }
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("(T_T)<(^-^<)");
        }
    }


}
