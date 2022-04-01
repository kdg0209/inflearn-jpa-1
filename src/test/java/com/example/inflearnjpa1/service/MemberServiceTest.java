package com.example.inflearnjpa1.service;

import com.example.inflearnjpa1.entity.Member;
import com.example.inflearnjpa1.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {

        // given
        Member member = new Member();
        member.setName("KDG");

        // when
        Long id = memberService.join(member);

        // then
        Assertions.assertEquals(member, memberRepository.findOne(id));
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("kim 1");

        Member member2 = new Member();
        member2.setName("kim 1");

        // when
        memberService.join(member1);

        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }

        // then
        fail("예외가 발생해야 한다.");
    }
}