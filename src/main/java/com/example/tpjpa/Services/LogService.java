package com.example.tpjpa.Services;

import com.example.tpjpa.model.Logs;
import com.example.tpjpa.repository.LogRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public List<Logs> getAllLog(){
        List<Logs> logs = new ArrayList<Logs>();
        logRepository.findAll();
        return logs;
    }

    public Logs getlogbyId(Integer id){
        return logRepository.findById(id).get();
    }

    public void saveOrUpdate(Logs logs)
    {
        logRepository.save(logs);
    }

    public void delete(int id)
    {
        logRepository.deleteById(id);
    }
}
