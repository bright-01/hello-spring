package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    // DI 3가지 방법
    // 1. 생성자 주입 가장 권장한다
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 2. 필드 주입 권장 하지 않음.. 중간에 변경이 불가능
//    @Autowired private MemberService memberService1;

    // 3. setter 주입 권장하지 않음. public으로 메서드가 열여있어야함.
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }
//
}
