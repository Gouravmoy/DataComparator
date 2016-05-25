package dao;

import java.util.List;

import entity.Project;
import exceptions.PersistException;
import exceptions.ReadEntityException;

public interface ProjectDao {

	void addProject(Project project) throws PersistException;

	Project getProjectByID(Long ID) throws ReadEntityException;

	List<Project> getAllProjects() throws ReadEntityException;

	List<String> getAllProjectName() throws ReadEntityException;

}
