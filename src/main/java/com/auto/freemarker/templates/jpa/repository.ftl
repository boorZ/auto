<#if classPath??>
    package ${classPath};
</#if>

${imports}

public interface ${fileName} extends CommonRepository<${T}, Integer>{

}
