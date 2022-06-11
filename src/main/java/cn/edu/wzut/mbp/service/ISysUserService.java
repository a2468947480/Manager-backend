package cn.edu.wzut.mbp.service;

import cn.edu.wzut.mbp.entity.SysUser;
import cn.edu.wzut.mbp.entity.SysUserExt;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
//第三步
public interface ISysUserService extends IService<SysUser> {
    List<SysUserExt> getUserList();
}
