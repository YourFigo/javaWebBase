package cn.figo.web.test;

import cn.figo.web.dao.UserDao;
import cn.figo.web.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){

        User loginUser = new User();
        loginUser.setUsername("zhangsan");
        loginUser.setPassword("123456");
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
