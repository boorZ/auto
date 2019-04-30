<#if classPath??>
package ${classPath};
</#if>

${imports}

@RestController
@RequestMapping(value = "/")
public class ${fileName} u{
     @Autowired
    private ${Service} ${Service ? lower_case};

}