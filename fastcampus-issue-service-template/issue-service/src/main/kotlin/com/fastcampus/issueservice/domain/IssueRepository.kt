package com.fastcampus.issueservice.domain

import com.fastcampus.issueservice.domain.enums.IssueStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IssueRepository : JpaRepository<Issue, Long> {
    fun findAllByStatusOrderByCreatedAtDesc(status: IssueStatus) : List<Issue>?
}