package feign.consumer.service;

import feign.consumer.feignclient.HomeFeignClient;
import feign.consumer.pojo.OrderInfo;
import feign.consumer.pojo.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class HiService {

    @Resource
    HomeFeignClient homeFeignClient;

    public String sayHi(){
        return  homeFeignClient.sayHifromClient();
    }

    public String userid(Long id){
        return  homeFeignClient.userid(id);
    }

    public String userids(Long []ids){
        return  homeFeignClient.userids(ids);
    }

    public String userobj1(UserInfo userInfo){
        return  homeFeignClient.userobj1(userInfo);
    }

    public String userobj2(UserInfo userInfo){
        return  homeFeignClient.userobj2(userInfo);
    }

    public String usermap(Map<String, Object> map){
        return  homeFeignClient.usermap(map);
    }

    public String usermul(String msg, String msg2,UserInfo userInfo){
        return  homeFeignClient.usermul(msg,msg2,userInfo);
    }

    public String userbody(Map<String, Object> map){
        return  homeFeignClient.userbody(map);
    }
}
