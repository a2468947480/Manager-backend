package cn.edu.wzut.mbp.service;

import cn.edu.wzut.mbp.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
public interface ISysRoleService extends IService<SysRole> {
    //分页查询+模糊查询
    List<SysRole> findbyPage(Integer startindex,Integer pagesize,String name);
    //总数查询
    Integer maxsize(String name);

}
