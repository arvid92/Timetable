package de.nordakademie.iaa.service.impl;

import de.nordakademie.iaa.dao.CenturyDAO;
import de.nordakademie.iaa.model.Century;
import de.nordakademie.iaa.service.CenturyService;
import de.nordakademie.iaa.service.exception.NotEnoughChangeoverTimeProvidedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for century entities.
 *
 * @author Timo Schlatter
 */
@Service
@Transactional
public class CenturyServiceImpl implements CenturyService {

    private static final int MIN_CHANGEOVER_TIME = 15;
    private final CenturyDAO centuryDAO;

    @Autowired
    public CenturyServiceImpl(CenturyDAO centuryDAO) {
        this.centuryDAO = centuryDAO;
    }

    @Override
    public void saveCentury(Century century) throws NotEnoughChangeoverTimeProvidedException {
        final int actualMinChangeoverTime = century.getMinChangeoverTime();
        if (actualMinChangeoverTime < MIN_CHANGEOVER_TIME) {
            throw new NotEnoughChangeoverTimeProvidedException(century, MIN_CHANGEOVER_TIME, actualMinChangeoverTime);
        }
        centuryDAO.save(century);
    }

    @Override
    public List<Century> listCenturies() {
        return centuryDAO.findAll();
    }

    @Override
    public Century loadCentury(Long id) {
        return centuryDAO.findOne(id);
    }

    @Override
    public boolean deleteCentury(Long id) {
        Century century = loadCentury(id);
        if (century == null) {
            return false;
        }
        centuryDAO.delete(century);
        return true;
    }

    @Override
    public Century findCenturyByName(String name) {
        return centuryDAO.findByName(name);
    }
}