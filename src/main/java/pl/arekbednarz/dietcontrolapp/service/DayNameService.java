package pl.arekbednarz.dietcontrolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arekbednarz.dietcontrolapp.entity.DayName;
import pl.arekbednarz.dietcontrolapp.repository.DayNameRepository;

import java.util.List;

@Service
@Transactional
public class DayNameService
{
    @Autowired
    private DayNameRepository dayNameRepository;

    public List<DayName> findAll()
    {
        return dayNameRepository.findAll();
    }
}