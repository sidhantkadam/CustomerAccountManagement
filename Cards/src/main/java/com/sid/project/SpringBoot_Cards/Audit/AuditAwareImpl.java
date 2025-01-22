package com.sid.project.SpringBoot_Cards.Audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware
{

    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Cards_MS");
    }
}
