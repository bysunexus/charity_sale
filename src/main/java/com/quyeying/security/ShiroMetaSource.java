package com.quyeying.security;

import com.quyeying.charity.domain.Menu;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;

/**
 * User: bysun
 * Date: 2014/7/20
 * Time: 22:29
 */
public class ShiroMetaSource implements FactoryBean<Ini.Section> {
    public static final String PREMISSION_STRING="authc,roles[{0}]";
    @Autowired
    private IShiroUserService repo;

    @Override
    public Ini.Section getObject() throws Exception {
        //获取所有Resource
        List<Menu> list = repo.findAllMenu();

        Ini ini = new Ini();
        //加载默认的url
        ini.load("/static/**=anon\n/login=anon\n/logout=anon\n/unauthorized=authc\n/=authc\n");
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        for (Menu menu : list) {
            section.put(menu.getPath(), MessageFormat.format(PREMISSION_STRING, menu.getSign()));
        }
        section.put("/**", "authc,roles[**]");
        return section;
    }

    @Override
    public Class<Ini.Section> getObjectType() {
        return Ini.Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
