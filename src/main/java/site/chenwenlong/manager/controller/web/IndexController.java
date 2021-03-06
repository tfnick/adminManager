package site.chenwenlong.manager.controller.web;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.chenwenlong.manager.controller.BaseController;
import site.chenwenlong.manager.entity.word.Means;
import site.chenwenlong.manager.entity.word.Word;
import site.chenwenlong.manager.service.sys.IUserService;
import site.chenwenlong.manager.service.word.IMeansService;
import site.chenwenlong.manager.service.word.IWordService;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IWordService wordService;

    @Autowired
    private IMeansService meansService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/", "/api/index"})
    @ResponseBody
    public Object index() {
        String serverName = request.getServerName();
        System.out.println(serverName);
        String requestURL = request.getRequestURI();
        System.out.println(requestURL);

        Means means = meansService.find(1);
        Page<Word> query = wordService.query("get", null, 0, 10);
        Object o = JSONObject.toJSON(query);
        return o;
    }
}
