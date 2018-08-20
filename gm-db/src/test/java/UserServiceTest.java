import com.mst.db.Application;
import com.mst.db.domain.UserInfo;
import com.mst.db.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {
    @Resource(name = "UserServiceImpl")
    private UserService userService;
    @Test
    public void  addUser(){
        UserInfo userInfo=new UserInfo();
        userInfo.setCreateTime(LocalDateTime.now());
        userService.addUserByRegist(userInfo);
    }


}
