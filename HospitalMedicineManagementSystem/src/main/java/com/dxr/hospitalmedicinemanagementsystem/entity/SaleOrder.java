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
import java.time.LocalDateTime;

/**
 * <p>
 * 药品销售单主表
 * </p>
 *
 * @author dxr
 * @since 2025-10-29
 */
@Getter
@Setter
@ToString
@TableName("sale_order")
public class SaleOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售单ID
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 销售单号（如XS20251029001）
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 患者姓名
     */
    @TableField("patient_name")
    private String patientName;

    /**
     * 销售时间
     */
    @TableField("sale_date")
    private LocalDateTime saleDate;

    /**
     * 销售总金额（≥0）
     */
    @TableField("total_amount")
    private BigDecimal totalAmount;

    /**
     * 操作人ID（关联用户表）
     */
    @TableField("operator_id")
    private Integer operatorId;

    /**
     * 逻辑删除（0=未删，1=已删）
     */
    @TableLogic
    @TableField("deleted")
    private Byte deleted;
}
