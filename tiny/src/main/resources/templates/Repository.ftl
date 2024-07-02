package ${packageName};

import ${packageName?substring(0, packageName?last_index_of('.'))}.model.${className};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${className}Repository extends JpaRepository<${className}, Long> {
}
