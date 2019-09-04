package timimg.springcloud.provider.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {
    @GetMapping("/get")
    @ResponseBody
    public String get(HttpServletResponse response, @RequestParam(value = "para") String para) {
        return para + "_get_service";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post(HttpServletResponse response, @RequestParam(value = "para") String para) {
        return para + "_post_service";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put(HttpServletResponse response, @RequestParam(value = "para") String para) {
        System.out.println(para + "_put_service");
        return para + "_put_service";
    }

    @DeleteMapping("/delete/{para}")
    @ResponseBody
    public String delete(HttpServletResponse response, @PathVariable(value = "para") String para) {
        System.out.println(para + "_delete_service");
        return para + "_delete_service";
    }

}
