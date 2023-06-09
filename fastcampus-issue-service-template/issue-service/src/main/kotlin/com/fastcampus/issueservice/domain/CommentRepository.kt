package com.fastcampus.issueservice.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByIdAndUserId(id: Long, userId: Long): Comment?
}