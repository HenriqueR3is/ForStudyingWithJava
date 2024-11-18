package com.kanban.taskmanager.model.users;

public record RegisterDTO(String login, String password, UserRole role) {
}
