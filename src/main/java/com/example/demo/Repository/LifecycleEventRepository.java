public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {
    List<LifecycleEvent> findByAsset_Id(Long id);
}
