package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// TDD 개발 방식 -> 테스트 케이스 먼저 작성 후 구현 : 테스트 주도 개발


public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    // 테스트가 끝난후 실행되는 메서드
    @AfterEach
    public void afterEach(){
        memberRepository.clearStory();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);
        Member result = memberRepository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);


    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member  = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member2  = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
