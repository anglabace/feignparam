package feign.consumer.feignclient;

import feign.consumer.pojo.OrderInfo;
import feign.consumer.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value="lhdprovider")
public interface HomeFeignClient {
     @GetMapping(value="/home/hello")
     String sayHifromClient();

     @GetMapping(value="/home/user/{id}")
     String userid(@PathVariable(value="id") Long id);

     @GetMapping(value="/home/users")
     String userids(@RequestParam("ids") Long []ids);

     @RequestMapping(value = "/home/userobj1", method=RequestMethod.POST)
     String userobj1(@RequestBody UserInfo userinfo);

     @RequestMapping(value = "/home/userobj2", method=RequestMethod.POST)
     String userobj2(@SpringQueryMap UserInfo userinfo);

     @RequestMapping(value = "/home/usermap", method=RequestMethod.POST)
     String usermap(@RequestBody Map<String, Object> map);

     @RequestMapping(value = "/home/usermul", method=RequestMethod.POST)
     String usermul(@RequestParam("msg") String msg,@RequestParam("msg2")String msg2,@SpringQueryMap UserInfo userInfo);

     @RequestMapping(value = "/home/userbody", method=RequestMethod.POST)
     String userbody(@RequestBody Map<String, Object> map);

}
