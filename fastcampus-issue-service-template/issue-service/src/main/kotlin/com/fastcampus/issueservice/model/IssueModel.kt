package com.fastcampus.issueservice.model

import com.fastcampus.issueservice.domain.Comment
import com.fastcampus.issueservice.domain.Issue
import com.fastcampus.issueservice.domain.enums.IssuePriority
import com.fastcampus.issueservice.domain.enums.IssueStatus
import com.fastcampus.issueservice.domain.enums.IssueType
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime


data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
)

data class IssueResponse(
    val id: Long,
    val summary: String,
    val description: String,
    val userId: Long,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
    val comments : List<CommentResponse> = emptyList(),
) {
    companion object {
        // with를 쓴이유가 issue.id, issue.summary를 안해서 사용한듯
        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse(
                    id = id!!,
                    summary = summary,
                    description = description,
                    userId = userId,
                    type = type,
                    priority = priority,
                    status = status,
                    createdAt = createdAt,
                    updatedAt = updatedAt,
                    comments = comments.sortedByDescending(Comment::id).map(Comment::toResponse),
                )
            }
    }
}