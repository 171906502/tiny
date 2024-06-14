package ${packageName};

import jakarta.persistence.*;
import lombok.Data;
<#if bigDecimal?? && bigDecimal == 1>
import java.math.BigDecimal;
</#if>
<#if localDate?? && localDate == 1>
import java.time.*;
</#if>

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
