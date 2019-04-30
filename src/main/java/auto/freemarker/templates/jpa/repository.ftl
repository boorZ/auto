<#if classPath??>
package ${classPath};
</#if>

${imports}

@NoRepositoryBean
public interface ${fileName} extends CommonRepository<${T}, Integer>{

}