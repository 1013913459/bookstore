package priv.dhx.bookstore.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.dhx.bookstore.domain.Book;

@Mapper
public interface BookMapper
{
    Book selectById(String id);

    Boolean insert(Book book);
}