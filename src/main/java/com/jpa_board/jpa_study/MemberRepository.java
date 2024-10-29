package com.jpa_board.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/* dao 같은 친구 */
@Repository
public class MemberRepository {

    /* 엔티티 매니저 */
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();

    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

}
