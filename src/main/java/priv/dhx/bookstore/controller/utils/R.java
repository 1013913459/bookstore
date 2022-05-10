package priv.dhx.bookstore.controller.utils;

import lombok.Data;

@Data
public class R
{
    private Boolean flag;
    private Object data;
    private String desc;

    public R(String desc)
    {
        this.flag = false;
        this.desc = desc;
    }

    public R(Boolean flag, Object data)
    {
        this.flag = flag;
        this.data = data;
    }
}