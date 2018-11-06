package com.ssm.dao;

import com.ssm.domain.Member;

public interface MemberDao {

    /**
     * 通过id去查询到Member
     * @param id
     * @return
     */
    Member findMemberById(String id);
}
