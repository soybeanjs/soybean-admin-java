package com.soybean.portal.ctrl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author：美式续命
 * @date: 2024/6/23
 * @Copyright：
 */
@RequestMapping("/sys/")
@RestController
public class SysCtrl {

    // 会话登录接口
    // 登录接口
    @RequestMapping("doLogin")
    public SaResult doLogin() {
        // 第1步，先登录上
        StpUtil.login(10001);
        // 第2步，获取 Token  相关参数
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 第3步，返回给前端
        return SaResult.data(tokenInfo);
    }


}
