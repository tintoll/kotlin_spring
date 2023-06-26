package com.fastcampus.issueservice.service

import com.fastcampus.issueservice.domain.Issue
import com.fastcampus.issueservice.domain.IssueRepository
import com.fastcampus.issueservice.domain.enums.IssueStatus
import com.fastcampus.issueservice.exception.NotFoundException
import com.fastcampus.issueservice.model.IssueRequest
import com.fastcampus.issueservice.model.IssueResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository
) {

    @Transactional
    fun create(userId: Long, request: IssueRequest): IssueResponse {
        val issue = Issue(
            userId = userId,
            summary = request.summary,
            description = request.description,
            type = request.type,
            priority = request.priority,
            status = request.status
        )
        return IssueResponse(issueRepository.save(issue))
    }

    fun getAll(status: IssueStatus): List<IssueResponse>? {
        return issueRepository.findAllByStatusOrderByCreatedAtDesc(status)?.map {
            IssueResponse(it)
        }
    }

    fun get(id: Long): IssueResponse {
        val issue = issueRepository.findByIdOrNull(id) ?: throw NotFoundException("이슈가 존재하지 않습니다.")
        return IssueResponse(issue)
    }

    fun edit(userId: Long, id: Long, request: IssueRequest): IssueResponse {
        val issue = issueRepository.findByIdOrNull(id) ?: throw NotFoundException("이슈가 존재하지 않습니다.")
        return with(issue) {
            status = request.status
            summary = request.summary
            description = request.description
            this.userId = userId
            type = request.type
            priority = request.priority
            IssueResponse(issueRepository.save(this))
        }
    }

}