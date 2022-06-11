package cn.edu.wzut.mbp.mapper;

import cn.edu.wzut.mbp.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysUserMapperTest {
    @Autowired
    private SysUserMapper sysUserMapper;


    @Test
    void retrieveAll(){
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser.getUsername());
        }
    }
}