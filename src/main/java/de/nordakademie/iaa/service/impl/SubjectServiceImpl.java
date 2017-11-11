package de.nordakademie.iaa.service.impl;

import de.nordakademie.iaa.dao.SubjectDAO;
import de.nordakademie.iaa.model.Module;
import de.nordakademie.iaa.model.Subject;
import de.nordakademie.iaa.model.SubjectType;
import de.nordakademie.iaa.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDAO subjectDAO;

    @Autowired
    public SubjectServiceImpl(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public void saveSubject(Subject subject) {
        subjectDAO.save(subject);
    }

    @Override
    public List<Subject> listSubjects() {
        return subjectDAO.findAll();
    }

    @Override
    public Subject loadSubject(Long id) {
        return subjectDAO.findOne(id);
    }

    @Override
    public boolean deleteSubject(Long id) {
        Subject subject = loadSubject(id);
        if (subject == null) {
            return false;
        }
        subjectDAO.delete(subject);
        return true;
    }

    @Override
    public Subject findSubjectBySubjectTypeAndModule(SubjectType subjectType, Module module) {
        return subjectDAO.findBySubjectTypeAndModule(subjectType, module);
    }

    @Override
    public List<Subject> findSubjectBySubjectType(SubjectType subjectType) {
        return subjectDAO.findBySubjectType(subjectType);
    }

    @Override
    public void deleteSubjectByModule(Module module) {
        subjectDAO.deleteByModule(module);
    }
}
