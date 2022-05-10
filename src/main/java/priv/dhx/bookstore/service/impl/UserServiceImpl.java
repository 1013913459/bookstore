package priv.dhx.bookstore.service.impl;

import org.springframework.stereotype.Service;
import priv.dhx.bookstore.domain.User;
import priv.dhx.bookstore.mapper.UserMapper;
import priv.dhx.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper)
    {
        this.mapper = mapper;
    }

    @Override
    public Boolean register(String account, String nickname, String password)
    {
        return mapper.insert(new User(account, nickname, password));
    }

    @Override
    public Boolean login(String account, String password)
    {
        return password.equals(mapper.selectByAccount(account).getPassword());
    }

    @Override
    public Boolean isThisAccountExist(String account)
    {
        return mapper.selectByAccount(account) != null;
    }
}