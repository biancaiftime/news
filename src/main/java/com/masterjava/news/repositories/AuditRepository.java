package com.masterjava.news.repositories;

import com.masterjava.news.helpers.queries.AuditQueries;
import com.masterjava.news.models.Audit;
import com.masterjava.news.models.Author;
import com.masterjava.news.models.ObjectType;
import com.masterjava.news.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Audit> getAudit() {return jdbcTemplate.query(AuditQueries.getAudit, new BeanPropertyRowMapper<>(Audit.class));}

    public List<Audit> getAuditByOperation(Operation operation)
    {
        return jdbcTemplate.query(AuditQueries.getRecordsByOperation, new Object[]{operation},new BeanPropertyRowMapper<>(Audit.class));
    }
    public List<Audit> getAuditByObjectType(ObjectType objectType)
    {
        return jdbcTemplate.query(AuditQueries.getRecordsByObjectType, new Object[]{objectType},new BeanPropertyRowMapper<>(Audit.class));
    }

    public List<Audit> addRecord(Audit audit)
    {
        jdbcTemplate.update(AuditQueries.addRecord, audit.getOperation().name(), audit.getObjectType().name(), audit.getDescription(), audit.getDate());
        return jdbcTemplate.query(AuditQueries.getAudit, new BeanPropertyRowMapper<>(Audit.class));
    }

    public List<Audit> deleteRecord(int id)
    {
        jdbcTemplate.update(AuditQueries.deleteRecord, id);
        return jdbcTemplate.query(AuditQueries.getAudit, new BeanPropertyRowMapper<>(Audit.class));
    }
}
