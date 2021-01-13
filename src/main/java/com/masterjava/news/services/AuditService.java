package com.masterjava.news.services;


import com.masterjava.news.models.Audit;
import com.masterjava.news.repositories.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public List<Audit> getAudit() {return auditRepository.getAudit();}

    public List<Audit> deleteRecord(int id) {return auditRepository.deleteRecord(id);}
}
