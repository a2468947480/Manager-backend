package cn.edu.wzut.mbp.service.impl;

import cn.edu.wzut.mbp.entity.SysDept;
import cn.edu.wzut.mbp.mapper.SysDeptMapper;
import cn.edu.wzut.mbp.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
    @Autowired
    SysDeptMapper sysDeptMapper;
    @Override
    public List<SysDept> listTree() {
        HashMap<BigDecimal, SysDept> set = new HashMap<>();
        List<SysDept> roots = new ArrayList<>();
        for (SysDept item : this.list()) {
            set.put(item.getId(), item);
        }

        for (SysDept item : set.values()) {
            if (item.getParentId() == null)
                roots.add(item);
            else {
                SysDept parent = set.get(item.getParentId());
                if (parent.getChildren() == null)
                    parent.setChildren(new ArrayList<>());
                parent.getChildren().add(item);
            }
        }

        return roots;
    }

    @Override
    public Integer findmaxid(){
        return sysDeptMapper.findmaxid();
    }
    @Override
    public  Integer findchild(Integer id){
        return sysDeptMapper.findchild(id);
    }
}
