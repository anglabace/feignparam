package feign.consumer.controller;

import feign.consumer.pojo.OrderInfo;
import feign.consumer.pojo.UserInfo;
import feign.consumer.service.HiService;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Resource
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi(){
        return hiService.sayHi();
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable(value="id") Long id){
        return hiService.userid(id);
    }

    @GetMapping("/users")
    public String users(@RequestParam("ids") Long []ids){
        return hiService.userids(ids);
    }

    @GetMapping("/userobj1")
    public String userobj(@RequestParam("id") Long id,
                          @RequestParam("name") String name
    ){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(id);
        userInfo.setUserName(name);
        System.out.println(userInfo.getUserId()+"--"+userInfo.getUserName());
        return hiService.userobj1(userInfo);
    }

    @GetMapping("/userobj2")
    public String userobj2(@RequestParam("id") Long id,
                          @RequestParam("name") String name
    ){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(id);
        userInfo.setUserName(name);
        System.out.println(userInfo.getUserId()+"--"+userInfo.getUserName());
        return hiService.userobj2(userInfo);
    }


    @GetMapping("/usermap")
    public String usermap(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg1","a text message");
        map.put("msg2","第二条测试消息");
        return hiService.usermap(map);
    }


    @GetMapping("/usermul")
    public String usermul(@RequestParam("id") Long id,
                          @RequestParam("name") String name
    ){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(id);
        userInfo.setUserName(name);
        return hiService.usermul("a text message","message2",userInfo);
    }


    @GetMapping("/userbody")
    public String userbody(@RequestParam("id") Long id,
                          @RequestParam("name") String name
    ){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(id);
        userInfo.setUserName(name);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","a text message");
        map.put("user",JSON.toJSONString(userInfo));

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(id);
        orderInfo.setGoodsName("高档保温杯 by "+name);

        map.put("order",JSON.toJSONString(orderInfo));

        return hiService.userbody(map);
    }
}
