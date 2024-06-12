package ${packageName};

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ${className}Dto {

<#list fields as field>
    @NotNull
    private ${field?split(":")[1]} ${field?split(":")[0]};
</#list>

}
