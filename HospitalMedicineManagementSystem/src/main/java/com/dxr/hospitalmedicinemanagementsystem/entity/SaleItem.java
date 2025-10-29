package com.dxr.hospitalmedicinemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 药品销售明细表
 * </p>
 *
 * @author dxr
 * @since 2025-10-29
 */
@Getter
@Setter
@ToString
@TableName("sale_item")
public class SaleItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 明细ID
     */
    @TableId(value = "item_id", type = IdType.AUTO)
    private Integer itemId;

    /**
     * 关联销售单ID
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 关联药品ID
     */
    @TableField("medicine_id")
    private Integer medicineId;

    /**
     * 销售批号
     */
    @TableField("batch_number")
    private String batchNumber;

    /**
     * 销售数量（>0）
     */
    @TableField("quantity")
    private Integer quantity;

    /**
     * 销售单价（>0）
     */
    @TableField("unit_price")
    private BigDecimal unitPrice;

    /**
     * 逻辑删除（0=未删，1=已删）
     */
    @TableLogic
    @TableField("deleted")
    private Byte deleted;
}
