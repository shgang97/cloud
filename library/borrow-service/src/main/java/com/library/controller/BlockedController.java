package com.library.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shg
 * @create: 2022-05-03 7:45 下午
 */
@RestController
public class BlockedController {
    @RequestMapping(value = "/blocked", method = RequestMethod.GET)
    public JSONObject getBlocked() {
        JSONObject json = new JSONObject();
        json.put("code", 403);
        json.put("success", false);
        json.put("massage", "您的请求频率过快，请稍后再试！");
        return json;
    }
}
