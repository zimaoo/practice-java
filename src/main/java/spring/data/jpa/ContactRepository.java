package spring.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangxinpeng
 * @date 2020/3/12
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    /**
     * 无法实现动态更新
     * @param mobile
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE contact SET mobile =:mobile WHERE id =:id", nativeQuery = true)
    void updateMobile(@Param("mobile") String mobile, @Param("id") Integer id);
}
