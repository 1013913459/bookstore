package priv.dhx.bookstore.controller;

import org.springframework.web.bind.annotation.*;
import priv.dhx.bookstore.controller.utils.R;
import priv.dhx.bookstore.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    private final UserService service;

    public UserController(UserService service)
    {
        this.service = service;
    }

    @GetMapping("/account-exist")
    public R checkAccountExist(String account)
    {
        return new R(true, service.isThisAccountExist(account));
    }

    @PostMapping("/register")
    public R register(@RequestBody Map<String, String> map)
    {
        return new R(true, service.register(map.get("account"), map.get("nickname"), map.get("password")));
    }

    @PostMapping("/login")
    public R login(@RequestBody Map<String, String> map)
    {
        return new R(true, service.login(map.get("account"), map.get("password")));
    }
}