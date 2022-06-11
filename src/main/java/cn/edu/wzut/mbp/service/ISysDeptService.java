package cn.edu.wzut.mbp.service;

import cn.edu.wzut.mbp.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
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
public interface ISysDeptService extends IService<SysDept> {
    List<SysDept> listTree();
    Integer findmaxid();
    Integer findchild(Integer id);
}
