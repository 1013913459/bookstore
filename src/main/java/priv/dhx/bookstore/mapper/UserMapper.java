package priv.dhx.bookstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.dhx.bookstore.domain.User;

@Mapper
public interface UserMapper
{
    User selectByAccount(String account);

    Boolean insert(User user);
}