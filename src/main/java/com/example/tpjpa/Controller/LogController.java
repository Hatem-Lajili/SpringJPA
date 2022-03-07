package com.example.tpjpa.Controller;

import com.example.tpjpa.Services.LogService;
import com.example.tpjpa.model.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/all")
    private List<Logs> getAllBooks()
    {
        return logService.getAllLog();
    }

    @PostMapping("/add")
    private int saveLog (@RequestBody Logs logs){
        logService.saveOrUpdate(logs);
        return logs.getId();
    }

}
