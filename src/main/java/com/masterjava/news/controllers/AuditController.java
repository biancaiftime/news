package com.masterjava.news.controllers;

import com.masterjava.news.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping()
    public ResponseEntity<?> getAudit(){return ResponseEntity.ok().body(auditService.getAudit());}

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRecord(@RequestParam int id) {return ResponseEntity.ok().body(auditService.deleteRecord(id));}

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {auditService.deleteAll(); return ResponseEntity.ok("Deleted all audit");}
}
