package com.fastcampus.issueservice.domain

import com.fastcampus.issueservice.domain.enums.IssuePriority
import com.fastcampus.issueservice.domain.enums.IssueStatus
import com.fastcampus.issueservice.domain.enums.IssueType
import javax.persistence.*

@Entity
@Table
class Issue (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = 0,

    @Column
    var userId : Long,
    @Column
    var summary : String,
    @Column
    var description : String,
    @Column
    @Enumerated(EnumType.STRING)
    var type : IssueType,
    @Column
    @Enumerated(EnumType.STRING)
    var priority : IssuePriority,
    @Column
    @Enumerated(EnumType.STRING)
    var status : IssueStatus
    ) : BaseEntity()