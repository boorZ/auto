<#if classPath??>
package ${classPath};
</#if>

${imports}

@RestController
@RequestMapping(value = "/")
public class ${fileName} {
    @Autowired
    private ${Service} ${Service ? lower_case};

}