package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.model.Task
import com.notslaves.taskmanager.repository.TaskRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TaskService(
    private val mapper: TaskMapper,
    private val repository: TaskRepository
) {
    @Transactional
    fun getAllTasks(): List<Task> = repository.findAll().map { mapper.entityToModel(it) }

    @Transactional
    fun changeTaskStatus(taskId: Int, statusId: Int): Task? {
        val foundTask = getTask(taskId)
        return foundTask?.let {
            foundTask.status = statusId
            repository.save(mapper.modelToEntity(foundTask))
            foundTask
        }
    }

    @Transactional
    fun getTask(id: Int): Task? = repository.findById(id)
        .orElse(null)?.let { mapper.entityToModel(it) }

    @Transactional
    fun getAllTasksByProjectId(id: Int): List<Task> = repository.findAllByProjectId(id)
        .map { mapper.entityToModel(it) }

    @Transactional
    fun createTask(task: Task): Task {
        val entity = mapper.modelToEntity(task)
        return mapper.entityToModel(repository.save(entity))
    }

    @Transactional
    fun deleteTask(id: Int) = repository.deleteById(id)

    @Transactional
    fun modifyTask(id: Int, task: Task): Task? {
        val foundTask = getTask(id)
        return foundTask?.let {
            task.created = foundTask.created
            repository.save(mapper.modelToEntity(task))
            task
        }
    }
}