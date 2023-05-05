package dev.SeungIL.example.Controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.LoggingCacheErrorHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller // 기본적으로 view를 제공하거나 데이터를 제공하는 용도로서 넓은 범위에 사용하는 어노테이션, ResponseBody 어노테이션을 사용해야 됨
@RequestMapping("view")
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-jsp")
    public String sampleJsp(Model model){
        logger.info("/sample-jsp");
        List<SamplePayload> profiles = new ArrayList<>();

        profiles.add(new SamplePayload("Adam",22,"student"));
        profiles.add(new SamplePayload("Seung Il",24,"student"));
        profiles.add(new SamplePayload("babo",23,"student"));

        model.addAttribute("profiles", profiles);

        return "view-jsp";

    }
    @GetMapping("/sample-thyme")
    public ModelAndView sampleThyme(){
    logger.info("in sample thyme");
    ModelAndView modelAndView = new ModelAndView();

    List<SamplePayload> profiles = new ArrayList<>();

    profiles.add(new SamplePayload("Adam",22,"student"));
    profiles.add(new SamplePayload("Seung Il",24,"student"));
    profiles.add(new SamplePayload("babo",23,"student"));

    modelAndView.addObject("profiles",profiles);
    modelAndView.setViewName("view-thyme");
    return modelAndView;

    }



//    @GetMapping(
//            value = "hello"//브라우저가아니라 url에서 경로를 설정하는 부분이 값으로 들어가는 어노테이션
//
//    ) //어떤 경로에 어떤 함수가 들어갈지 정할 때 등장하는 어노테이션
//    public String hello(@RequestParam(name = "id", required = false, defaultValue = "")String id){
//
//        logger.info("Path : Hello");
//        logger.info("Query Param id : " + id);
//        return "/hello.html"; // 경로를 hello.html을 되돌려 주므로 가능, 하지만 hello만 쓰면 안됨. 위에 어노테이션의 hello를 그냥 돌려주기 때문에
//
//    }
//    @GetMapping(
//            value = "/hello/{id}"
//    )
//    public String helloPath(@PathVariable("id")String id){
//        logger.info("Path Variable is" + id);
//        return "/hello.html";
//    }
//    @GetMapping(
//            "get-profile"
//    )
//    public @ResponseBody     SamplePayload getProfile(){
//        return new SamplePayload("SeungIL",10,"Developer");
//    }
//    // html body에 데이터를 보내고 싶을 때 @ResponseBody 어노테이션을 씀

}
