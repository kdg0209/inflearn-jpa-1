package com.example.inflearnjpa1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    void testMember() {
        Member member = new Member();
        member.setName("Member A");
        Long saveId = memberRepository.save(member);

        Member findMember = memberRepository.find(saveId);

        org.assertj.core.api.Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        org.assertj.core.api.Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        org.assertj.core.api.Assertions.assertThat(findMember).isEqualTo(member);
    }
}