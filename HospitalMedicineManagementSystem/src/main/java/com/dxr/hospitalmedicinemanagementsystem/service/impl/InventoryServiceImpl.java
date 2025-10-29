package com.dxr.hospitalmedicinemanagementsystem.service.impl;

import com.dxr.hospitalmedicinemanagementsystem.entity.Inventory;
import com.dxr.hospitalmedicinemanagementsystem.mapper.InventoryMapper;
import com.dxr.hospitalmedicinemanagementsystem.service.IInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品库存表 服务实现类
 * </p>
 *
 * @author dxr
 * @since 2025-10-29
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {

}
