package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
/**
 *@Controller 는 반환 값이 String 이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링 된다.
 * @RestController 는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력한다. 따라서
 * 실행 결과로 ok 메세지를 받을 수 있다.
 */
@RestController
@Slf4j
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass()); -> @Slf4j가 대신 적어줌


    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log={}", name); //trace 출력 안되면 연산 안됨
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        //로그를 사용하지 않아도 a+b 계산(연산->메모리와 CPU 사용) 로직이 먼저 실행됨, + 로 연결 등 이런 방식으로 사용하면 X
        log.debug("String concat log=" + name); //이게 출력안될때 쓸모없이 리소스를 사용하게 되는 것
        return "ok";
    }
}