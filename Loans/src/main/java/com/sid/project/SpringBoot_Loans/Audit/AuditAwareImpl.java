package com.sid.project.SpringBoot_Loans.Audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware
{

    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("LOAN_MS");
    }
}
