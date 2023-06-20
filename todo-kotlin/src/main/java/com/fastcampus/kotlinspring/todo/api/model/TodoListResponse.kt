package com.fastcampus.kotlinspring.todo.api.model

import com.fastcampus.kotlinspring.todo.domain.Todo
import com.fasterxml.jackson.annotation.JsonIgnore

data class TodoListResponse(
    private val items: List<TodoResponse>
) {
    val size: Int
        @JsonIgnore
        get() = items.size

    fun get(index: Int): TodoResponse = items[index]

    companion object {
        fun of(todoList : List<Todo>) : TodoListResponse {
            return TodoListResponse(todoList.map(TodoResponse::of))
        }
    }

}