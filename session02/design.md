# Task & User Management RESTful API

## Overview
System manages Users and Tasks.
- One User has many Tasks
- One Task belongs to one User

## Base URL
http://localhost:8080/api

## User Endpoints

### Get all users
GET /users

### Create user
POST /users
{
  "username": "user2",
  "email": "user2@gmail.com",
  "role": "USER"
}

### Update user role
PATCH /users/{id}/role
{
  "role": "ADMIN"
}

### Delete user
DELETE /users/{id}

### Get user's tasks
GET /users/{id}/tasks

## Task Endpoints

### Get all tasks
GET /tasks

### Create task
POST /tasks
{
  "title": "Fix bug",
  "description": "Fix login bug",
  "priority": "HIGH",
  "status": "OPEN",
  "userId": 1
}

### Update task status
PATCH /tasks/{id}/status
{
  "status": "DONE"
}

### Delete task
DELETE /tasks/{id}

## Filtering

### Tasks with HIGH priority
GET /tasks?priority=HIGH

### Tasks with HIGH priority and userId
GET /tasks?priority=HIGH&userId=1

## Assign Task

PATCH /tasks/{id}/assign
{
  "userId": 1
}
