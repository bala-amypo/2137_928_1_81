package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.LifecycleEvent;
import com.example.demo.entity.User;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LifecycleEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {

    private final LifecycleEventRepository repo;
    private final AssetRepository assetRepo;
    private final UserRepository userRepo;

    public LifecycleEventServiceImpl(LifecycleEventRepository repo,
                                     AssetRepository assetRepo,
                                     UserRepository userRepo) {
        this.repo = repo;
        this.assetRepo = assetRepo;
        this.userRepo = userRepo;
    }

    @Override
    public LifecycleEvent logEvent(Long assetId, Long userId, LifecycleEvent event) {

        Asset asset = assetRepo.findById(assetId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        event.setAsset(asset);
        event.setPerformedBy(user);
        event.prePersist();

        return repo.save(event);
    }

    @Override
    public List<LifecycleEvent> getEventsForAsset(Long assetId) {
        return repo.findByAsset_Id(assetId);
    }
}
