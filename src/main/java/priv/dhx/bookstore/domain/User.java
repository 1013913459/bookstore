package priv.dhx.bookstore.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User
{
    private Long uid;
    private String account;
    private String nickname;
    private String password;

    public User(String account, String nickname, String password)
    {
        this.account = account;
        this.nickname = nickname;
        this.password = password;
    }
}