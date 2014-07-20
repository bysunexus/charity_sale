package com.quyeying.charity.account.service;

import com.quyeying.charity.domain.Menu;
import com.quyeying.charity.domain.User;
import com.quyeying.charity.domain.UserMenu;
import com.quyeying.config.AppCtxCfg;
import com.quyeying.config.AppCtxCfgMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppCtxCfg.class, AppCtxCfgMongo.class,AppCtxCfgMongo.class}, loader = AnnotationConfigContextLoader.class)
public class UserRepositoryTest {
    @Resource(name = "userRepository")
    UserRepository repo;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testSave() throws Exception {
//        User user = new User();
//        user.setPassword("111111");
//        user.setUserName("admin");
//        user.setNickName("管理员");
//        user.setLevel(User.UserLevel.ADMIN.getValue());
//        user.setGroup("A");
//
//        repo.save(user);
//
//        Menu menu = new Menu();
//        menu.setCreateTime(System.currentTimeMillis());
//        menu.setName("业务功能");
//        menu.setOrder(1);
//        menu.setPath("");
//        menu.setPid("");
//        menu.setSign("BIZ_OPT");
//
//        mongoTemplate.save(menu);
//
//        Menu menu1 = new Menu();
//        menu1.setCreateTime(System.currentTimeMillis());
//        menu1.setName("商品出入库");
//        menu1.setOrder(1);
//        menu1.setPath("/storage");
//        menu1.setPid(menu.getPkid());
//        menu1.setSign("BIZ_OPT_STORAGE");
//
//        mongoTemplate.save(menu1);
//        Menu menu = mongoTemplate.findOne(new Query(Criteria.where("pkid").is("53cbe4f66ad06e68c35bb796")),Menu.class);
//        UserMenu um = new UserMenu();
//        um.setUserId("53cbe4f66ad06e68c35bb794");
//
//        List<Menu> list = new ArrayList<>();
//        list.add(menu);
//        um.setMenus(list);
//
//        mongoTemplate.save(um);
    }

}