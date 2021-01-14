package com.masterjava.news.helpers.aspects;

import com.masterjava.news.helpers.Helpers;
import com.masterjava.news.models.Audit;
import com.masterjava.news.models.ObjectType;
import com.masterjava.news.models.Operation;
import com.masterjava.news.repositories.AuditRepository;
import com.masterjava.news.services.ArticleService;
import com.masterjava.news.services.AuthorService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AuthorAspect {

    static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    @Autowired
    private AuditRepository auditRepository;

    @AfterReturning(value = "execution(* com.masterjava.news.services.AuthorService.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint)
    {
        Operation op = Helpers.getOperation(joinPoint.getSignature().toString());
        auditRepository.addRecord(new Audit(op, ObjectType.Author, joinPoint.getSignature().toString(), new Date()));
        logger.info(joinPoint.getSignature().toString());
    }
}
