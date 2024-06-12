package ${packageName};

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "${table}")
public class ${className} {

<#list fields as field>
    <#if field?split(":")[2] == "PrimaryKey">
    @Id
    @GeneratedValue
    <#else>
    @Column(name = "${field?split(":")[0]}")
    </#if>
    private ${field?split(":")[1]} ${field?split(":")[3]};
</#list>


}
