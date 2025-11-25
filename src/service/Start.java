package service;

public interface Start {
    String times();
    boolean login(String konsoleEmail,String konsolePassword);
    void updateLogin(String konsoleEmail,String newPassword);


}
