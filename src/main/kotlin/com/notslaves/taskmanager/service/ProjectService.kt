package com.notslaves.taskmanager.service

import com.notslaves.taskmanager.model.Project
import com.notslaves.taskmanager.repository.ProjectRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ProjectService(
    private val mapper: ProjectMapper,
    private val repository: ProjectRepository
) {
    @Transactional
    fun getAllProject(): List<Project> = repository.findAll().map { mapper.entityToModel(it) }

    @Transactional
    fun getProject(id: Int): Project? = repository.findById(id)
        .orElse(null)?.let { mapper.entityToModel(it) }

    @Transactional
    fun getAllProjectsByUserId(id: Int): List<Project> = repository.findAllByUserId(id)
        .map { mapper.entityToModel(it) }

    // Todo: project names shouldn't be unique
    // Todo: Due to transaction, creation time is null. It shouldn't be
    @Transactional
    fun createProject(project: Project): Project {
        val entity = mapper.modelToEntity(project)
        return mapper.entityToModel(repository.save(entity))
    }

    @Transactional
    fun deleteProject(id: Int) = repository.deleteById(id)

    @Transactional
    fun modifyProject(id: Int, project: Project): Project? {
        val foundProject = getProject(id)
        return foundProject?.let {
            project.created = foundProject.created
            repository.save(mapper.modelToEntity(project))
            project
        }
    }
}