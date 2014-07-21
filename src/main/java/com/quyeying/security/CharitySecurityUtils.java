package com.quyeying.security;


import com.quyeying.charity.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CharitySecurityUtils {

    private static Logger log = LoggerFactory.getLogger(SecurityUtils.class);

    public final static String CURRENT_USER = "CURRENT_USER";

    /**
     * 注册当前用户
     *
     * @param user 用户
     */
    public static void setCurrentUser(User user) {
        if (null != user) {
            setSession(CURRENT_USER, user);
        }
    }

    /**
     * 获取当前用户
     *
     * @return 当前登录用户
     */
    public static User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                User user = (User) session.getAttribute(CURRENT_USER);
                if (null != user) {
                    return user;
                }
            }
        }
        return null;
    }

    /**
     * 移除当前登录用户
     *
     * @param user 用户
     */
    public static void removeCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            session.removeAttribute(CURRENT_USER);
        }
    }



    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     *
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    public static void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            log.debug("Shiro 的 Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            session.setAttribute(key, value);
        }
    }
}
