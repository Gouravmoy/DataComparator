package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.ProjectDao;
import entity.Project;
import exceptions.PersistException;
import exceptions.ReadEntityException;

public class ProjectDaoImpl extends GenericDAOImpl<Project, Long> implements
		ProjectDao {

	@Override
	public void addProject(Project project) throws PersistException {
		try {
			save(project);
		} catch (Exception e) {
			throw new PersistException();
		}

	}

	@Override
	public Project getProjectByID(Long ID) throws ReadEntityException {
		try {
			return readById(Project.class, ID);
		} catch (Exception e) {
			throw new ReadEntityException();
		}
	}

	@Override
	public List<Project> getAllProjects() throws ReadEntityException {
		try {
			return readAll("Project.finadAll", Project.class);
		} catch (Exception e) {
			throw new ReadEntityException();
		}
	}

	@Override
	public List<String> getAllProjectName() throws ReadEntityException {
		try {
			List<String> listOfProjects = new ArrayList<String>();
			for (Project p : readAll("Project.finadAll", Project.class)) {
				listOfProjects.add(p.getProjectName());
			}
			return listOfProjects;
		} catch (Exception e) {
			throw new ReadEntityException();
		}
	}

}
