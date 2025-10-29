package com.dxr.hospitalmedicinemanagementsystem;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxr.hospitalmedicinemanagementsystem.entity.Medicine;
import com.dxr.hospitalmedicinemanagementsystem.entity.User;
import com.dxr.hospitalmedicinemanagementsystem.entity.query.UserQuery;
import com.dxr.hospitalmedicinemanagementsystem.mapper.MedicineMapper;
import com.dxr.hospitalmedicinemanagementsystem.mapper.UserMapper;
import com.dxr.hospitalmedicinemanagementsystem.service.tempservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MedicineMapper medicineMapper;
    @Test
    public void testFindById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void testAdd() {
        User user = new User(null, "dxr", "123456", 2, 0);
        userMapper.insert(user);
        //MP插入成功后，可以直接获取主键的值
        System.out.println("这里是键值："+user.getId());
    }

    //修改
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);//改哪个
        user.setUsername("dxr123");//改什么
        userMapper.updateById(user);
    }

    //根据id删除
    @Test
    public void testDelete() {
        userMapper.deleteById(5);
    }
    //批量删除
    @Test
    public void testDeleteBatchIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(7);
        ids.add(8);
        userMapper.deleteBatchIds(ids);
    }

    //根据字段条件删除
    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap();
        map.put("username", "dxr");//这里要放数据库的列名而不是实体类属性名
        userMapper.deleteByMap(map);
    }



    //根据id查询
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    //根据id批量查询
    @Test
    public void testSelectBatchIds() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
       List<User> userList = userMapper.selectBatchIds(ids);
       for (User user : userList) {
           System.out.println(user);
       }
    }
    //根据字段条件查询
    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap();
        map.put("role", 1);//不是模糊查询，多个条件是且的关系
        List<User> userList = userMapper.selectByMap(map);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    //条件构造器
    @Test
    public void testSelectByWrapper1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("id", 3).or().gt("id", 3);
        List<User> userList = userMapper.selectList(queryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    //条件查询中的NULL处理
    @Test
    public void testSelectByWrapper2() {
        UserQuery uq = new UserQuery();
//        uq.setId(1); 不设置条件就是null
       uq.setId2(3);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(null!=uq.getId(),User::getId, uq.getId());//没有第一个参数时，哪怕获得的是null也会和其他正常条件拼接查询，导致查不到东西，而设置了后只要是null就会忽略条件
        queryWrapper.lt(null!=uq.getId2(),User::getId, uq.getId2());
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println("条件查询中的NULL处理");
        for (User user : userList) {
            System.out.println(user);
        }


    }
    //查询投影 （有选择的显示）
    @Test
    public void testSelectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("id","username","role");
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.select(User::getId,User::getUsername,User::getRole);//Lambda和其他wrapper select形参不一样。
        
//        List<User> userList = userMapper.selectList(queryWrapper);因为选择了查哪些字段所以selectList这个方法查完后没查到的字段会为null，所以用selectMaps
        queryWrapper.select("count(*) as count,role");
        queryWrapper.groupBy("role");
        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        for (var  user : userList) {
            System.out.println(user);
        }


    }
    //基础分页
    //select*from_user ?????? limit ?,?
    @Test
    public void testSelectPage() {
        //必须配置分页拦截器(config)
        IPage page = new Page(2,2);
        userMapper.selectPage(page, null);
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }

    //乐观锁
    @Test
    public void testOptimisticLocker() {
        //1.设置version
//        Medicine medicine =new Medicine();
//        medicine.setMedicineId(1);
//        medicine.setName("红药");
//        medicine.setVersion(1);//一定要传version
//        medicineMapper.updateById(medicine);
        //2.直接查
//        Medicine medicine = medicineMapper.selectById(1);
//        medicine.setName("蓝药");
//        medicineMapper.updateById(medicine);
        Medicine medicine1 = medicineMapper.selectById(1);
        Medicine medicine2 = medicineMapper.selectById(1);
        medicine1.setName("蓝药");
        medicineMapper.updateById(medicine1);
        medicine2.setName("黄药");
        medicineMapper.updateById(medicine2);


    }
}
