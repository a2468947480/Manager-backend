package cn.edu.wzut.mbp.entity;

import lombok.Data;


//第一步
@Data
public class SysUserExt extends SysUser {
    private String roleName;
    private String deptName;
}
