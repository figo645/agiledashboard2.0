package com.example.dashboard.service;

import com.example.dashboard.entity.ChangeTracking;
import com.example.dashboard.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeService {
    @Value("${use.postgresql}")
    private boolean usePostgresql;

    @Autowired
    @Qualifier("csvDataRepository")
    private DataRepository csvDataRepository;

    @Autowired
    @Qualifier("postgresDataRepository")
    private DataRepository postgresDataRepository;

    private DataRepository getDataRepository() {
        return usePostgresql ? postgresDataRepository : csvDataRepository;
    }

    public List<ChangeTracking> getChangeTrackingData() {
        return getDataRepository().getChangeTrackingData();
    }
} 