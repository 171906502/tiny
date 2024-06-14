package ${packageName};

import lombok.Data;
<#if bigDecimal?? && bigDecimal == 1>
import java.math.BigDecimal;
</#if>
<#if localDate?? && localDate == 1>
import java.time.*;
</#if>

@Data
public class ${className}Dto {

<#list fields as field>
    private ${field?split(":")[1]} ${field?split(":")[0]};
    
</#list>

}
