package com.ruoyi.project.system.user.service;

import com.ruoyi.project.llc.people.domain.People;
import com.ruoyi.project.llc.people.service.PeopleRepository;
import com.ruoyi.project.system.files.domain.Files;
import com.ruoyi.project.system.files.service.FilesRepository;
import com.ruoyi.project.system.files.service.IFilesService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:Ricardo
 * Description:
 * Date: 2019/3/11
 * Time: 15:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private IUserService userService;

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private FilesRepository filesRepository;
    @Autowired
    private IFilesService filesService;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void addUser(){
        List<People> peopleList = peopleRepository.findAll();
        for (People people: peopleList){
            User user = new User();
            user.setDeptId(Integer.toUnsignedLong(113));
            user.setLoginName(people.getName());
            if(people.getPhone().isEmpty())user.setPassword("111111");
            else {
                user.setPassword(people.getPhone());
            }
            user.setUserName(people.getName());
            user.setEmail(people.getEmail());
            user.setPhonenumber(people.getPhone());
            if("男".equals(people.getSex()))user.setSex("0");
            else user.setSex("1");
            Files files = filesService.selectFilesById(people.getPortrait());
            if(files!=null){
                user.setAvatar(files.getFileName()+"."+files.getSuffix());
            }
            Long[] roleIds = {Integer.toUnsignedLong(3)};
            user.setRoleIds(roleIds);
            Long[] post = {Integer.toUnsignedLong(4)};
            user.setPostIds(post);

            user.setStatus("0");
            user.setDelFlag("0");
            user.setCreateBy("admin");
            user.setCreateTime(new Date());
            user.setUpdateBy("admin");
            user.setUpdateTime(new Date());
            user.setRemark(people.getName());

            userService.insertUser(user);
        }
    }
    @Test
    public void updateUser(){
        List<People> peopleList = peopleRepository.findAll();
        for (People people: peopleList){

            User user = userService.selectUserByLoginName(people.getName());
            if(user !=null){
                System.out.println("user = "+user.getLoginName());
                Files files = filesService.selectFilesById(people.getPortrait());
                if(files!=null){
                    user.setAvatar(files.getFileName()+"."+files.getSuffix());
                }
                userMapper.updateUser(user);
            }
        }
    }

    @Test
    public void resetPassw(){
        User user = userService.selectUserByLoginName("admin");
        if(user != null){
            user.setPassword("llcweb123");
            userService.resetUserPwd(user);
        }
    }
}