package priv.dhx.bookstore.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book
{
    private Long bid;
    private String id;
    private String name;
    private Double price;
    private String introduction;

    public Book(String id, String name, Double price, String introduction)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.introduction = introduction;
    }
}