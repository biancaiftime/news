package com.masterjava.news.helpers.queries;

public class AuditQueries {
    public static final String getAudit = "SELECT * FROM dbo.Audit";
    public static final String addRecord = "INSERT INTO dbo.Audit(operation,objectType,description,date) VALUES (?,?,?,?)";
    public static final String getRecordsByObjectType = "SELECT * FROM dbo.Audit WHERE objectType = ? ";
    public static final String getRecordsByOperation = "SELECT * FROM dbo.Audit WHERE operation = ? ";
    public static final String deleteRecord = "DELETE FROM dbo.Audit WHERE id = ?";
    public static final String deleteAll = "DELETE FROM dbo.Audit";
}
