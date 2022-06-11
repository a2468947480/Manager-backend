package cn.edu.wzut.controller;

import cn.edu.wzut.jwt.JWTHelper;
import cn.edu.wzut.jwt.PassToken;
import cn.edu.wzut.jwt.UserLoginToken;
import cn.edu.wzut.mbp.entity.SysUser;
import cn.edu.wzut.mbp.entity.SysUserExt;
import cn.edu.wzut.mbp.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ISysUserService userService;

    @PassToken
    @PostMapping("/login")
    public JsonResult<String> login(String username, String password) throws MyException {
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper
                .eq("username", username)
                .eq("password", password);
        SysUser sysUser = userService.getOne(sysUserQueryWrapper);
        if(sysUser != null){
            String token = JWTHelper.getToken(sysUser);
            return new JsonResult<>(token);
        }
        else{
            throw new MyException("登录失败");
        }
    }

    @PostMapping
    public JsonResult<Object> save(@RequestBody SysUser sysUser) throws MyException {
        boolean b = userService.saveOrUpdate(sysUser);
        if(b)
            return new JsonResult<>(0, "修改完成");
        else
            throw new MyException("修改失败");
    }

    @UserLoginToken
    @GetMapping
    public JsonResult<List<SysUserExt>> all() {
        List<SysUserExt> userList = userService.getUserList();
        return new JsonResult<>(userList);
    }

    @GetMapping("/{id}")
    public JsonResult<SysUser> get(@PathVariable("id") BigDecimal id) {
        SysUser sysUser = userService.getById(id);
        return new JsonResult<>(sysUser);
    }

    @DeleteMapping("/{id}")
    public JsonResult<Object> deleteOne(@PathVariable("id") BigDecimal id) throws MyException {
        boolean b = userService.removeById(id);
        if(b)
            return new JsonResult<>(0, "删除完成");
        else
            throw new MyException("删除失败");
    }

    @DeleteMapping
    public JsonResult<Object> deleteMany(@RequestBody BigDecimal[] ids) throws MyException {
        boolean b = userService.removeByIds(Arrays.asList(ids));
        if(b)
            return new JsonResult<>(0, "删除完成");
        else
            throw new MyException("删除失败");
    }
}
