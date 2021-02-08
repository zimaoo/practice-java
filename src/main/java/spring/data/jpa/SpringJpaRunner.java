package spring.data.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author zhangxinpeng
 * @date 2020/3/12
 */
@Component
@Slf4j
public class SpringJpaRunner implements ApplicationRunner {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Optional<Contact> optional = contactRepository.findById(1);
//        if (!optional.isPresent()) {
//            return;
//        }

        // Contact contact = optional.get();
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("PengG");
        contact.setMobile("1784506173");
        contact.setAddress("BeiJ");
//        if (contact.getId() != null) {
//            contactRepository.save(contact);
//        }

        Optional<Contact> optionalContact = contactRepository.findById(contact.getId());
        if (optionalContact.isPresent()) {
            JpaUtil.copyNotNullProperties(contact, optionalContact.get());
            contactRepository.save(optionalContact.get());
        }

        // contactRepository.updateMobile("232323", 1);
    }
}
