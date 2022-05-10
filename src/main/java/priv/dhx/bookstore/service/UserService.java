package priv.dhx.bookstore.service;

public interface UserService
{
    Boolean register(String account, String nickname, String password);

    Boolean login(String account, String password);

    Boolean isThisAccountExist(String account);
}