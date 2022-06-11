package cn.edu.wzut.mbp.entity;

import cn.edu.wzut.mbp.entity.EntityBase;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzut
 * @since 2022-04-27
 */
@Getter
@Setter
@TableName("SYS_DEPT")
public class SysDept extends EntityBase {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;

    private String deptName;

    private BigDecimal parentId;

    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_NULL) //当children为空时，json忽略此字段
    private List<SysDept> children;
}
