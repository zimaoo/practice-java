package spring.data.jpa;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhangxinpeng
 * @date 2020/3/12
 */
@DynamicUpdate
@Data
@Entity(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String mobile;
    private String address;
    @Column(name = "create_time")
    private Date createTime;
}
