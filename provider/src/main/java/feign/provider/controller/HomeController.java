package feign.provider.controller;

import feign.provider.pojo.OrderInfo;
import feign.provider.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    //test api
    @GetMapping("/user/{id}")
    public String path(@PathVariable("id") Long id) {
        String res = "当前用户id:"+id;
        return res;
    }

    @GetMapping("/users")
    public String users(@RequestParam("ids") Long []ids){
        String res = "当前用户id列表:";
        for (Long id:ids) {
            res += id+",";
        }
        return res;
    }

    @RequestMapping(value = "/userobj1", method = RequestMethod.POST)
    public String userobj1(@RequestBody UserInfo userInfo){
        String res = "使用了@RequestBody :当前用户信息:id="+userInfo.getUserId();
       res+=";name="+userInfo.getUserName();
       return res;
    }

    @RequestMapping(value = "/userobj2", method = RequestMethod.POST)
    public String userobj2(UserInfo userInfo){
        String res = "未使用@RequestBody :当前用户信息:id="+userInfo.getUserId();
        res+=";name="+userInfo.getUserName();
        return res;
    }

    @RequestMapping(value = "/usermap", method = RequestMethod.POST)
    public String usermap(@RequestBody Map<String, Object> map){
        String res =";msg1="+map.get("msg1");
        res+=";msg2="+map.get("msg2");
        return res;
    }

    @RequestMapping(value = "/usermul", method = RequestMethod.POST)
    public String usermul(String msg, String msg2,UserInfo userInfo){
        String res = "多参数传递:当前用户信息:userid="+userInfo.getUserId();
        res+=";user name="+userInfo.getUserName();
        res+=";msg="+msg;
        res+=";msg2="+msg2;
        return res;
    }


    @RequestMapping(value = "/userbody", method = RequestMethod.POST)
    public String userbody(@RequestBody Map<String, Object> map){

        String userstr = (String)map.get("user");
        System.out.println(userstr);
        UserInfo userInfo = JSON.parseObject(userstr, UserInfo.class);
        System.out.println(userInfo);
        String res = ";msg="+map.get("msg");
        res+=";name="+userInfo.getUserName();
        res += ";id="+userInfo.getUserId();

        String orderstr = (String)map.get("order");
        System.out.println(userstr);
        OrderInfo orderInfo = JSON.parseObject(orderstr, OrderInfo.class);
        System.out.println(userInfo);
        res+=";orderid="+orderInfo.getOrderId();
        res+=";order goodsname="+orderInfo.getGoodsName();

        return res;
    }

}
