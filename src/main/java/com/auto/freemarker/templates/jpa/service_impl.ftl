<#if classPath??>
    package ${classPath};
</#if>

${imports}

@Service
public class ${fileName} implements ${Service} {
@Autowired
private ${Repository} ${Repository ? uncap_first};

@Override
public CommonRepository<${T}, Integer> getCommonRepository() {
return this.${Repository ? uncap_first};
}

}
