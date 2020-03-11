package ${baseDaoPackage};

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ${modelPackage}.${entityName};
<#if pkJavaType=="Date" || tenantKeyJavaType=="Date">
import java.util.Date;
<#elseif pkJavaType=="BigDecimal" || tenantKeyJavaType=="BigDecimal">
import java.math.BigDecimal;
</#if>


public interface ${entityName}BaseDao {
   void  insert(${entityName} dto);
   void  updateByPK(${entityName} dto);
   void  updateSelectiveByPK(${entityName} dto);
   void  deleteByPK(@Param("${primaryKey}") ${pkJavaType} ${primaryKey}<#if hasTenant?string("true","false")== "true">,@Param("${tenantKey}") ${tenantKeyJavaType} ${tenantKey}</#if>);
   ${entityName}  selectByPK(@Param("${primaryKey}") ${pkJavaType} ${primaryKey}<#if hasTenant?string("true","false")== "true">,@Param("${tenantKey}") ${tenantKeyJavaType} ${tenantKey}</#if>);
   List<${entityName}> selectByDto(${entityName} dto);
   
}